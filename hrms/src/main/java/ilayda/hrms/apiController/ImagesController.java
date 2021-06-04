package ilayda.hrms.apiController;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ilayda.hrms.business.abstracts.ImageService;
import ilayda.hrms.core.services.CloudinaryService;
import ilayda.hrms.core.utilities.result.DataResult;
import ilayda.hrms.core.utilities.result.ErrorResult;
import ilayda.hrms.core.utilities.result.Result;
import ilayda.hrms.core.utilities.result.SuccessResult;
import ilayda.hrms.dataAccess.abstracts.CreateCvDao;
import ilayda.hrms.entities.concretes.Image;
import ilayda.hrms.entities.concretes.User;
import lombok.var;


@RestController
@RequestMapping("/api/images")
public class ImagesController {
	
	private CloudinaryService cloudinaryService;
    private ImageService imageService;
    private CreateCvDao cvDao;

    @Autowired
    public ImagesController(CloudinaryService cloudinaryService, ImageService imageService,CreateCvDao cvDao) {
        this.cloudinaryService = cloudinaryService;
        this.imageService = imageService;
        this.cvDao=cvDao;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.imageService.getAll());
    }

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile ,@RequestParam int cvId){
        try {
            BufferedImage bufferedImage= ImageIO.read(multipartFile.getInputStream());
            if(bufferedImage==null){
                return ResponseEntity.badRequest().body(new ErrorResult("Resim validasyonu başarısız"));
            }
        }catch (IOException exception){
            return ResponseEntity.badRequest().body(new ErrorResult("Resim validasyonu başarısız"));
        }

        try {
            Map result= cloudinaryService.upload(multipartFile);
            Image image=new Image();
            image.setName((String)result.get("original_filename"));
            image.setImageUrl((String)result.get("url"));
            image.setImageId((String)result.get("public_id"));
            image.setCv(this.cvDao.getByCvId(cvId));
            return ResponseEntity.ok(this.imageService.add(image));
        }catch (IOException exception){
            return ResponseEntity.badRequest().body(new ErrorResult("Resim yukleme aşamasında bir sorun oluştu"));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam int id){
        if(!this.imageService.isExist(id)){
            return ResponseEntity.badRequest().body(new ErrorResult("Böyle bir resim bulunamadı"));
        }

        try {
            Image image=this.imageService.getById(id).getData();
            Map result=cloudinaryService.delete(image.getImageId());
            this.imageService.delete(id);
            return ResponseEntity.ok(new SuccessResult("Resim başarıyla silindi"));
        }catch (IOException exception){
            return ResponseEntity.badRequest().body(new ErrorResult("Bir hata oluştu"));
        }



    }


}

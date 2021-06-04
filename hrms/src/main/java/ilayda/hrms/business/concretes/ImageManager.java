package ilayda.hrms.business.concretes;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ilayda.hrms.business.abstracts.ImageService;
import ilayda.hrms.core.utilities.result.DataResult;
import ilayda.hrms.core.utilities.result.ErrorDataResult;
import ilayda.hrms.core.utilities.result.Result;
import ilayda.hrms.core.utilities.result.SuccessDataResult;
import ilayda.hrms.core.utilities.result.SuccessResult;
import ilayda.hrms.dataAccess.abstracts.ImageDao;
import ilayda.hrms.entities.concretes.Image;

@Service
@Transactional
public class ImageManager implements ImageService {
	
	 ImageDao imageDao;

	    @Autowired
	    public ImageManager(ImageDao imageDao) {
	        this.imageDao = imageDao;
	    }

	    @Override
	    public DataResult<List<Image>> getAll() {
	        return new SuccessDataResult<List<Image>>(this.imageDao.findByOrderById(),"Data listelendi");
	    }

	    @Override
	    public Result add(Image image) {
	        this.imageDao.save(image);
	        return new SuccessResult("Başarıyla eklendi");
	    }

	    @Override
	    public Result delete(int id) {
	        this.imageDao.deleteById(id);
	        return new SuccessResult("Başarıyla silindi");
	    }

	    @Override
	    public DataResult<Image> getById(int id) {
	        if(!this.imageDao.existsById(id)){
	            return new ErrorDataResult<Image>("Bu idye ait resim bulunamadı");
	        }
	        return new SuccessDataResult<Image>(this.imageDao.getById(id),"Verilen id ye ait resim listelendi");
	    }

	    @Override
	    public Boolean isExist(int id) {
	        return this.imageDao.existsById(id);
	    }


}

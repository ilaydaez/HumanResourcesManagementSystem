package ilayda.hrms.business.concretes;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ilayda.hrms.business.abstracts.ImageService;
import ilayda.hrms.core.utilities.result.DataResult;
import ilayda.hrms.core.utilities.result.Result;
import ilayda.hrms.core.utilities.result.SuccessDataResult;
import ilayda.hrms.core.utilities.result.SuccessResult;
import ilayda.hrms.dataAccess.abstracts.ImageDao;
import ilayda.hrms.entities.concretes.Image;

@Service
@Transactional
public class ImageManager implements ImageService {
	
	private ImageDao imageDao;

	@Autowired
	public ImageManager(ImageDao imageDao) {
		super();
		this.imageDao = imageDao;
	}

	@Override
	public Result add(Image image) {
		this.imageDao.save(image);
		return new SuccessResult("Resim yüklendi");
	}

	@Override
	public Result delete(int imageId) {
		this.imageDao.deleteById(imageId);
		return new SuccessResult("Resim silindi");
	}

	@Override
	public DataResult<Image> getByImageId(int imageId) {
		return new SuccessDataResult<Image>(this.imageDao.getByImageId(imageId));
	}

	@Override
	public DataResult<List<Image>> getAll() {
		return new SuccessDataResult<List<Image>>(this.imageDao.findAll(), "Resimler listelendi");
	}


}

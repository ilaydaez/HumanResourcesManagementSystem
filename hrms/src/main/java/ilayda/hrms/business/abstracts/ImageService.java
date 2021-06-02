package ilayda.hrms.business.abstracts;

import java.util.List;

import ilayda.hrms.core.utilities.result.DataResult;
import ilayda.hrms.core.utilities.result.Result;
import ilayda.hrms.entities.concretes.Image;

public interface ImageService {
	
	Result add(Image image);

	Result delete(int imageId);

	DataResult<List<Image>> getAll();

	DataResult<Image> getByImageId(int imageId);

}

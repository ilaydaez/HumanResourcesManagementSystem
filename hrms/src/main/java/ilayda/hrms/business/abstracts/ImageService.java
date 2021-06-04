package ilayda.hrms.business.abstracts;

import java.util.List;

import ilayda.hrms.core.utilities.result.DataResult;
import ilayda.hrms.core.utilities.result.Result;
import ilayda.hrms.entities.concretes.Image;

public interface ImageService {
	
	 DataResult<List<Image>> getAll();
	    Result add(Image image);
	    Result delete(int id);
	    DataResult<Image> getById(int id);
	    Boolean isExist(int id);

}

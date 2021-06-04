package ilayda.hrms.business.abstracts;

import java.util.Date;
import java.util.List;

import ilayda.hrms.core.utilities.result.DataResult;
import ilayda.hrms.core.utilities.result.Result;
import ilayda.hrms.entities.concretes.CreateCv;

public interface CreateCvSrevice {
	
	Result addCv(CreateCv cv);
	
	DataResult<List<CreateCv>> getAll();

}

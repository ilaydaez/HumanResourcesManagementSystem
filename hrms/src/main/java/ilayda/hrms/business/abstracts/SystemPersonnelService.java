package ilayda.hrms.business.abstracts;

import java.util.List;

import ilayda.hrms.core.utilities.result.DataResult;
import ilayda.hrms.core.utilities.result.Result;
import ilayda.hrms.entities.concretes.SystemPersonnel;

public interface SystemPersonnelService {
	
	DataResult<List<SystemPersonnel>> getAll();
	Result add(SystemPersonnel personnel);
	Result delete(SystemPersonnel personnel);
	Result update(SystemPersonnel personnel);

}

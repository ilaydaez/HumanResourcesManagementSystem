package ilayda.hrms.business.abstracts;

import java.util.List;

import ilayda.hrms.core.utilities.result.DataResult;
import ilayda.hrms.core.utilities.result.Result;
import ilayda.hrms.entities.concretes.Employer;

public interface EmployerService {
	
	DataResult<List<Employer>> getAll();
	Result add(Employer employer);
	Result delete(Employer employer);
	Result update(Employer employer);

}

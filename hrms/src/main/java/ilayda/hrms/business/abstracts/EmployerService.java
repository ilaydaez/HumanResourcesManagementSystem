package ilayda.hrms.business.abstracts;

import java.util.List;

import ilayda.hrms.core.utilities.result.DataResult;
import ilayda.hrms.core.utilities.result.Result;
import ilayda.hrms.entities.concretes.Employer;
import ilayda.hrms.entities.concretes.JobAdversiment;

public interface EmployerService {
	
	DataResult<List<Employer>> getAll();
	Result add(Employer employer);
	Result addJob(JobAdversiment adversiment);
	Result delete(Employer employer);
	Result update(Employer employer);

}

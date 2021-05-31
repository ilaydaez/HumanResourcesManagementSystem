package ilayda.hrms.business.abstracts;
import java.util.List;

import ilayda.hrms.core.utilities.result.DataResult;
import ilayda.hrms.core.utilities.result.Result;
import ilayda.hrms.entities.concretes.JobAdversiment;

public interface JobAdversimentService {

	Result add(JobAdversiment adversiment);
	Result update(JobAdversiment adversiment);
	Result changeOpenToClose(int id);
	
	DataResult<JobAdversiment> getByAdversimentId(int id);
	DataResult<List<JobAdversiment>> getAll();
	DataResult<List<JobAdversiment>> getAllSorted();
	DataResult<List<JobAdversiment>> getByIsActive();
	DataResult<List<JobAdversiment>> getByEmployer_CompanyNameAndIsActiveTrue(String companyName);

}

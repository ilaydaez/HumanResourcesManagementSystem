package ilayda.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import ilayda.hrms.core.utilities.result.DataResult;
import ilayda.hrms.core.utilities.result.Result;
import ilayda.hrms.entities.concretes.JobAdversiment;

public interface JobAdversimentService {
	
	DataResult<List<JobAdversiment>> getAll();
	Result add(JobAdversiment adversiment);
	
	DataResult<List<JobAdversiment>> getByIsActive(boolean active);
	DataResult<List<JobAdversiment>> getByListingDateAfter(LocalDate listingDate);
	DataResult<List<JobAdversiment>> getByEmployerAndIsActive(String employer, boolean active);

}

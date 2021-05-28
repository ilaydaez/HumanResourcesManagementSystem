package ilayda.hrms.business.abstracts;

import java.util.List;

import ilayda.hrms.core.utilities.result.DataResult;
import ilayda.hrms.core.utilities.result.Result;
import ilayda.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	
	DataResult<List<JobPosition>> getAll();
	DataResult<JobPosition> findByPositionEquals(String position);
	
	Result add(JobPosition position);
	Result delete(JobPosition position);
	Result update(JobPosition position);

}

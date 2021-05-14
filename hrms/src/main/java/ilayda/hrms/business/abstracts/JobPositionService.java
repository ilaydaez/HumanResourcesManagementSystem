package ilayda.hrms.business.abstracts;

import java.util.List;

import ilayda.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	
	List<JobPosition> getAll();
	void add(JobPosition position);
	void delete(JobPosition position);
	void update(JobPosition position);

}

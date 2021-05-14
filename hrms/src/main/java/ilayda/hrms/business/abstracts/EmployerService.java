package ilayda.hrms.business.abstracts;

import java.util.List;

import ilayda.hrms.entities.concretes.Employer;

public interface EmployerService {
	
	List<Employer> getAll();
	void add(Employer employer);
	void delete(Employer employer);
	void update(Employer employer);

}

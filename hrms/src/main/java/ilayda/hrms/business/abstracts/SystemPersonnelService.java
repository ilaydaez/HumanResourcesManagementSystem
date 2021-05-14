package ilayda.hrms.business.abstracts;

import java.util.List;

import ilayda.hrms.entities.concretes.SystemPersonnel;

public interface SystemPersonnelService {
	
	List<SystemPersonnel> getAll();
	void add(SystemPersonnel personnel);
	void delete(SystemPersonnel personnel);
	void update(SystemPersonnel personnel);

}

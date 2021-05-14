package ilayda.hrms.business.abstracts;

import java.util.List;

import ilayda.hrms.entities.concretes.User;

public interface UserService {
	
	List<User> getAll();
	void add (User user);
	void delete (User user);
	void update (User user);

}

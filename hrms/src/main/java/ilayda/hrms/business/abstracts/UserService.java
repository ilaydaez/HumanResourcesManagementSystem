package ilayda.hrms.business.abstracts;

import java.util.List;

import ilayda.hrms.core.utilities.result.DataResult;
import ilayda.hrms.core.utilities.result.Result;
import ilayda.hrms.entities.concretes.User;

public interface UserService {
	
	DataResult<List<User>> getAll();
	Result add (User user);
	Result delete (User user);
	Result update (User user);
	
	DataResult<User> getUserByEmail(String email);

}

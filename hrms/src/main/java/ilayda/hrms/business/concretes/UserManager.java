package ilayda.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ilayda.hrms.business.abstracts.UserService;
import ilayda.hrms.dataAccess.abstracts.UserDao;
import ilayda.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {
	
	private UserDao userDao;
	

	@Autowired
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getAll() {
		return this.userDao.findAll();
	}

	@Override
	public void add(User user) {
		if(user.getPassword()!=null && user.getPassword()!=null) {
			this.userDao.save(user);
		}else {
			return;
		}
		
	
	}

	@Override
	public void delete(User user) {
		this.userDao.delete(user);
		
	}

	@Override
	public void update(User user) {
		this.userDao.save(user);
		
	}

}

package ilayda.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ilayda.hrms.business.abstracts.UserService;
import ilayda.hrms.core.utilities.result.DataResult;
import ilayda.hrms.core.utilities.result.ErrorResult;
import ilayda.hrms.core.utilities.result.Result;
import ilayda.hrms.core.utilities.result.SuccessDataResult;
import ilayda.hrms.core.utilities.result.SuccessResult;
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
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Kullanıcılar Listelendi");
	}

	@Override
	public Result add(User user) {
		if(user.getPassword()!=null && user.getPassword()!=null) {
			this.userDao.save(user);
			return new SuccessResult("Kullanıcı Eklendi");
		}else {
			return new ErrorResult("Lütfen zorunlu alanları doldurunuz!!");
		}
		
	
	}

	@Override
	public Result delete(User user) {
		this.userDao.delete(user);
		return new SuccessResult("Kullanıcı Silindi");
		
	}

	@Override
	public Result update(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı Güncellendi");
		
	}
	
	@Override
	public DataResult<User> getUserByEmail(String email) {

		return new SuccessDataResult<User>(this.userDao.findUserByEmail(email));
	}


}

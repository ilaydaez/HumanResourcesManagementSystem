package ilayda.hrms.business.concretes;

import java.util.Date;

import org.springframework.stereotype.Service;

import ilayda.hrms.core.fakeServices.MernisService;
import ilayda.hrms.core.utilities.result.Result;
import ilayda.hrms.core.utilities.result.SuccessResult;

@Service
public class MernisManager implements MernisService {

	@Override
	public Result checkUser(String identityNumber, String firstName, String lastName, Date birthDate) {
		return new SuccessResult("Kullanıcı Doğrulandı : "+ firstName+ " "+ lastName);
	}

}

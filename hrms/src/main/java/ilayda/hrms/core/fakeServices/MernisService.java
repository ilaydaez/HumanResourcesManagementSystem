package ilayda.hrms.core.fakeServices;

import java.util.Date;

import ilayda.hrms.core.utilities.result.Result;

public interface MernisService {
	
	Result checkUser(String identityNumber, String firstName, String lastName, Date birthDate);
	

}

package ilayda.hrms.business.concretes;

import org.springframework.stereotype.Service;

import ilayda.hrms.core.fakeServices.EmailService;
import ilayda.hrms.core.utilities.result.Result;
import ilayda.hrms.core.utilities.result.SuccessResult;

@Service
public class EmailManager implements EmailService{

	@Override
	public Result sendEmail(String email) {
		return new SuccessResult(email+ " "+ "adresine mail doğrulama kodu gönderildi.");
	}

}

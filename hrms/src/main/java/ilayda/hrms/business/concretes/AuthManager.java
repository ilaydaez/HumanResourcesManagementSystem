package ilayda.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ilayda.hrms.business.abstracts.AuthService;
import ilayda.hrms.business.abstracts.EmployeeService;
import ilayda.hrms.business.abstracts.EmployerService;
import ilayda.hrms.business.abstracts.UserService;
import ilayda.hrms.core.fakeServices.EmailService;
import ilayda.hrms.core.fakeServices.MernisService;
import ilayda.hrms.core.utilities.result.DataResult;
import ilayda.hrms.core.utilities.result.ErrorDataResult;
import ilayda.hrms.core.utilities.result.SuccessDataResult;
import ilayda.hrms.entities.concretes.Employee;
import ilayda.hrms.entities.concretes.Employer;

@Service
public class AuthManager implements AuthService{
	
	private MernisService mernisService;
	private EmailService emailService;
	private EmployeeService employeeService;
	private EmployerService employerService;

	@Autowired
	public AuthManager(MernisService mernisService,EmailService emailService,EmployerService employerService,
			EmployeeService employeeService) {
		
		this.mernisService=mernisService;
		this.emailService=emailService;
		this.employeeService=employeeService;
		this.employerService=employerService;
	}

	//Employee kayıt olma başlangıc
	
	@Override
	public DataResult<List<Employee>> registerEmployee(Employee employee, String password) {

		if (!checkIfNullInfoForUser(employee)) {

			return new ErrorDataResult<List<Employee>>("Lütfen zorunlu alanları doldurunuz!!");
		}

		if (!checkIfEqualPasswordAndConfirmPassword(employee.getPassword(), password)) {

			return new ErrorDataResult<List<Employee>>("Parolalar eşleşmiyor");
		}

		mernisService.checkUser(employee.getIdentityNumber(), employee.getFirstName(), employee.getLastName(), employee.getBirthDate());
		employeeService.add(employee);
		return new SuccessDataResult<List<Employee>>("Doğrulama Kodu : "+ employee.getValidationCode()+" "+ 
		emailService.sendEmail(employee.getEmail()));
	
	}
	
	
	private boolean checkIfNullInfoForUser(Employee employee) {

		if (employee.getFirstName() !=null || employee.getLastName()!=null || employee.getIdentityNumber() !=null ||
				employee.getBirthDate()!=null || employee.getPassword()!=null || employee.getEmail()!=null) {

			return true;

		}

		return false;
	}

	private boolean checkIfEqualPasswordAndConfirmPassword(String password, String confirmPassword) {

		if (!password.equals(confirmPassword)) {
			return false;
		}

		return true;
	}

	
	//Employee kayıt olma bitis
	
	//Employer kayıt olma baslangıc
	
	@Override
	public DataResult<List<Employer>> registerEmployer(Employer employer, String password) {
		if (!checkIfNullInfoForUser(employer)) {

			return new ErrorDataResult<List<Employer>>("Lütfen zorunlu alanları doldurunuz!!");
		}
		
		if (!checkIfEqualPasswordAndConfirmPassword(employer.getPassword(), password)) {

			return new ErrorDataResult<List<Employer>>("Parolalar eşleşmiyor");
		}
		
		employerService.add(employer);
		return new SuccessDataResult<List<Employer>>("Doğrulama Kodu : "+ employer.getValidationCode()+" "+ 
				emailService.sendEmail(employer.getEmail()));
		
	}
	
	private boolean checkIfNullInfoForUser(Employer employer) {

		if (employer.getCompanyName() !=null || employer.getEmail()!=null || employer.getPhone() !=null ||employer.getPassword()!=null) {

			return true;

		}

		return false;
	}
	
	//Employer kayıt olma bitis

}

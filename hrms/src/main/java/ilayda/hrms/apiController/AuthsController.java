package ilayda.hrms.apiController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ilayda.hrms.business.abstracts.AuthService;
import ilayda.hrms.core.utilities.result.Result;
import ilayda.hrms.entities.concretes.Employee;
import ilayda.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/auths")
public class AuthsController {
	
	private AuthService authService;

	@Autowired
	public AuthsController(AuthService authService) {
		this.authService = authService;
	}
	
	@PostMapping("/registerEmployee")
	public Result registerEmployee(@RequestBody Employee employee, String password)
	{
		return authService.registerEmployee(employee, password);
	}
	
	@PostMapping("/registerEmployer")
	public Result registerEmployer(@RequestBody Employer employer, String password)
	{
		return authService.registerEmployer(employer, password);
	}


}

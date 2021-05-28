package ilayda.hrms.business.abstracts;

import java.util.List;

import ilayda.hrms.core.utilities.result.DataResult;
import ilayda.hrms.entities.concretes.Employee;
import ilayda.hrms.entities.concretes.Employer;

public interface AuthService {
	
	DataResult<List<Employee>> registerEmployee(Employee employee, String password);
	
	DataResult<List<Employer>> registerEmployer(Employer employer, String password);
	
	
	

}

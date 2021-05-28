package ilayda.hrms.business.abstracts;

import java.util.List;

import ilayda.hrms.core.utilities.result.DataResult;
import ilayda.hrms.core.utilities.result.Result;
import ilayda.hrms.entities.concretes.Employee;

public interface EmployeeService {
	
	DataResult<List<Employee>> getAll(); 
	
	Result add(Employee employee);
	Result delete(Employee employee);
	Result update(Employee employee);

}

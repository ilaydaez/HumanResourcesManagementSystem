package ilayda.hrms.business.abstracts;

import java.util.List;

import ilayda.hrms.entities.concretes.Employee;

public interface EmployeeService {
	
	List<Employee> getAll();
	void add(Employee employee);
	void delete(Employee employee);
	void update(Employee employee);

}

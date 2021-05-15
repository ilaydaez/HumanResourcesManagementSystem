package ilayda.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ilayda.hrms.business.abstracts.EmployeeService;
import ilayda.hrms.dataAccess.abstracts.EmployeeDao;
import ilayda.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService {
	
	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public List<Employee> getAll() {
		return this.employeeDao.findAll();
	}

	@Override
	public void add(Employee employee) {
		if(employee.getFirstName()!=null && employee.getLastName()!=null 
			&& employee.getIdentityNumber()!=null) {
			this.employeeDao.save(employee);
		}else {
			return;
		}
		
	}

	@Override
	public void delete(Employee employee) {
		this.employeeDao.delete(employee);
		
	}

	@Override
	public void update(Employee employee) {
		this.employeeDao.save(employee);
		
	}

}

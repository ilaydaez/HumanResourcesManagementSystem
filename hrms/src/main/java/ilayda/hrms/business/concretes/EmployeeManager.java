package ilayda.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ilayda.hrms.business.abstracts.EmployeeService;
import ilayda.hrms.core.utilities.result.DataResult;
import ilayda.hrms.core.utilities.result.ErrorResult;
import ilayda.hrms.core.utilities.result.Result;
import ilayda.hrms.core.utilities.result.SuccessDataResult;
import ilayda.hrms.core.utilities.result.SuccessResult;
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
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),"İş Arayanlar Listelendi");
	}

	@Override
	public Result add(Employee employee) {
		if(employee.getFirstName()!=null && employee.getLastName()!=null 
			&& employee.getIdentityNumber()!=null) {
			this.employeeDao.save(employee);
			return new SuccessResult("İş Arayan Eklendi");
		}else {
			return new ErrorResult("Lütfen zorunlu alanları doldurunuz!!");
		}
		
	}

	@Override
	public Result delete(Employee employee) {
		this.employeeDao.delete(employee);
		return new SuccessResult("İş Arayan Silindi");
		
	}

	@Override
	public Result update(Employee employee) {
		this.employeeDao.save(employee);
		return new SuccessResult("İş Arayan Güncellendi");
		
	}

}

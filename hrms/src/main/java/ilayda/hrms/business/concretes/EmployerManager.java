package ilayda.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ilayda.hrms.business.abstracts.EmployerService;
import ilayda.hrms.dataAccess.abstracts.EmployerDao;
import ilayda.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public List<Employer> getAll() {
		return this.employerDao.findAll();
	}

	@Override
	public void add(Employer employer) {
		if(employer.getPhone()!=null && employer.getCompanyName()!=null) {
			this.employerDao.save(employer);
		}else {
			return;
		}
		
	}

	@Override
	public void delete(Employer employer) {
		this.employerDao.delete(employer);
		
	}

	@Override
	public void update(Employer employer) {
		this.employerDao.save(employer);
		
	}

}

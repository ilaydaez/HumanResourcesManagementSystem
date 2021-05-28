package ilayda.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ilayda.hrms.business.abstracts.EmployerService;
import ilayda.hrms.core.utilities.result.DataResult;
import ilayda.hrms.core.utilities.result.ErrorResult;
import ilayda.hrms.core.utilities.result.Result;
import ilayda.hrms.core.utilities.result.SuccessDataResult;
import ilayda.hrms.core.utilities.result.SuccessResult;
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
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İş Verenler Listelendi");
	}

	@Override
	public Result add(Employer employer) {
		if(employer.getPhone()!=null && employer.getCompanyName()!=null) {
			this.employerDao.save(employer);
			return new SuccessResult("İş Veren Eklendi");
		}else {
			return new ErrorResult("Lütfen zorunlu alanları doldurunuz!!");
		}
		
	}

	@Override
	public Result delete(Employer employer) {
		this.employerDao.delete(employer);
		return new SuccessResult("İş Veren Silindi");
		
	}

	@Override
	public Result update(Employer employer) {
		this.employerDao.save(employer);
		return new SuccessResult("İş Veren Güncellendi");
		
	}

}

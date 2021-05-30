package ilayda.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ilayda.hrms.business.abstracts.EmployerService;
import ilayda.hrms.business.abstracts.JobAdversimentService;
import ilayda.hrms.core.utilities.result.DataResult;
import ilayda.hrms.core.utilities.result.ErrorResult;
import ilayda.hrms.core.utilities.result.Result;
import ilayda.hrms.core.utilities.result.SuccessDataResult;
import ilayda.hrms.core.utilities.result.SuccessResult;
import ilayda.hrms.dataAccess.abstracts.EmployerDao;
import ilayda.hrms.entities.concretes.Employer;
import ilayda.hrms.entities.concretes.JobAdversiment;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private JobAdversimentService adversimentService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, JobAdversimentService adversimentService) {
		super();
		this.employerDao = employerDao;
		this.adversimentService =adversimentService;
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

	@Override
	public Result addJob(JobAdversiment adversiment) {
		
		if(adversiment.isActive() == true) {
			
			this.adversimentService.add(adversiment);
			return new SuccessResult("İş İlanı Eklendi");
		}else {
			return new ErrorResult("Pasif ");
		}

	}

}

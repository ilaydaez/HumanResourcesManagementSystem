package ilayda.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ilayda.hrms.business.abstracts.JobAdversimentService;
import ilayda.hrms.core.utilities.result.DataResult;
import ilayda.hrms.core.utilities.result.ErrorDataResult;
import ilayda.hrms.core.utilities.result.Result;
import ilayda.hrms.core.utilities.result.SuccessDataResult;
import ilayda.hrms.core.utilities.result.SuccessResult;
import ilayda.hrms.dataAccess.abstracts.JobAdversimentDao;
import ilayda.hrms.entities.concretes.JobAdversiment;

@Service
public class JobAdversimentManager implements JobAdversimentService {
	
	private JobAdversimentDao adversimentDao;

	@Autowired
	public JobAdversimentManager(JobAdversimentDao adversimentDao) {
		super();
		this.adversimentDao = adversimentDao;
	}

	@Override
	public DataResult<List<JobAdversiment>> getAll() {
		return new SuccessDataResult<List<JobAdversiment>>(this.adversimentDao.findAll(),"İş İlanları Listelendi");
	}

	@Override
	public Result add(JobAdversiment adversiment) {
		
		adversiment = new JobAdversiment(true, LocalDate.now());
		this.adversimentDao.save(adversiment);
		return new SuccessResult("İş İlanı Eklendi");
	}

	@Override
	public DataResult<List<JobAdversiment>> getByIsActive(boolean active) {
		
		if(active == true) {
			return new SuccessDataResult<List<JobAdversiment>>(this.adversimentDao.getByIsActive(active),"Aktif iş İlanları");
		
		}else {
			return new ErrorDataResult<List<JobAdversiment>>("İş İlanı Bulunmamaktadır");
		}
		
	}

	@Override
	public DataResult<List<JobAdversiment>> getByListingDateAfter(LocalDate listingDate) {
		return new SuccessDataResult<List<JobAdversiment>>(this.adversimentDao.getByListingDateAfter(listingDate));
	}

	@Override
	public DataResult<List<JobAdversiment>> getByEmployerAndIsActive(String employer, boolean active) {
		return new SuccessDataResult<List<JobAdversiment>>(this.adversimentDao.getByEmployerAndIsActive(employer,active));
	}

}

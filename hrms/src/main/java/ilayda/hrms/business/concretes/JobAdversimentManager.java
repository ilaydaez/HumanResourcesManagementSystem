package ilayda.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ilayda.hrms.business.abstracts.JobAdversimentService;
import ilayda.hrms.core.utilities.result.DataResult;
import ilayda.hrms.core.utilities.result.ErrorResult;
import ilayda.hrms.core.utilities.result.Result;
import ilayda.hrms.core.utilities.result.SuccessDataResult;
import ilayda.hrms.core.utilities.result.SuccessResult;
import ilayda.hrms.dataAccess.abstracts.JobAdversimentDao;
import ilayda.hrms.entities.concretes.JobAdversiment;

@Service
public class JobAdversimentManager implements JobAdversimentService {
	
	private JobAdversimentDao adversimentDao;;

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
		this.adversimentDao.save(adversiment);
		return new SuccessResult("İş İlanı Eklendi");
	}
	
	@Override
	public Result update(JobAdversiment adversiment) {
		this.adversimentDao.save(adversiment);
		return new SuccessResult("İş İlanı Eklendi");
	}
	
	@Override
	public Result changeOpenToClose(int id) {
		if (getByAdversimentId(id) == null) {
			return new ErrorResult("Böyle bir iş ilanı yok");

		}
		if (getByAdversimentId(id).getData().isActive() == false) {
			return new ErrorResult("İş İlanı Zaten Kapalı");
		}

		JobAdversiment adversiment = getByAdversimentId(id).getData();
		adversiment.setActive(false);
		add(adversiment);
		return new SuccessResult("İş İlanı Başarıyla Kapatıldı");
	}

	@Override
	public DataResult<List<JobAdversiment>> getByIsActive() {

			return new SuccessDataResult<List<JobAdversiment>>(this.adversimentDao.getByIsActive(),"Aktif iş İlanları");

	}

	@Override
	public DataResult<List<JobAdversiment>> getByEmployer_CompanyNameAndIsActiveTrue(String companyName) {
		return new SuccessDataResult<List<JobAdversiment>>(this.adversimentDao.getByEmployer_CompanyNameAndIsActiveTrue(companyName));
	}

	@Override
	public DataResult<List<JobAdversiment>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"listingDate");
		return new SuccessDataResult<List<JobAdversiment>>(this.adversimentDao.findAll(sort),"Başarılı");
	}

	@Override
	public DataResult<JobAdversiment> getByAdversimentId(int id) {
		return new SuccessDataResult<JobAdversiment>(this.adversimentDao.getByAdversimentId(id));
	}


}

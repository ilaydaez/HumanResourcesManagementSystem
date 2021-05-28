package ilayda.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ilayda.hrms.business.abstracts.JobPositionService;
import ilayda.hrms.core.utilities.result.DataResult;
import ilayda.hrms.core.utilities.result.ErrorResult;
import ilayda.hrms.core.utilities.result.Result;
import ilayda.hrms.core.utilities.result.SuccessDataResult;
import ilayda.hrms.core.utilities.result.SuccessResult;
import ilayda.hrms.dataAccess.abstracts.JobPositionDao;
import ilayda.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{
	
	private JobPositionDao positionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao positionDao) {
		super();
		this.positionDao = positionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.positionDao.findAll(),"İş Pozisyonları Listelendi");
	}

	@Override
	public Result add(JobPosition position) {
		
		if(positionDao.findByPositionEquals(position.getPosition()) !=null) {
			return new ErrorResult("İş pozisyonu mevcut" + " " +"Ekleme Başarısız!!");
		}else {
			this.positionDao.save(position);
			 return new SuccessResult("İş Pozisyonu Eklendi");
		}

	}

	@Override
	public Result delete(JobPosition position) {
		this.positionDao.delete(position);
		return new SuccessResult("İş Pozisyonu Silindi");
		
	}

	@Override
	public Result update(JobPosition position) {
		this.positionDao.save(position);
		return new SuccessResult("İş Pozisyonu Güncellendi");
		
	}

	@Override
	public DataResult<JobPosition> findByPositionEquals(String position) {
		return new SuccessDataResult<JobPosition>(this.positionDao.findByPositionEquals(position), "İş posizyonu mevcut.");
	}


}

package ilayda.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ilayda.hrms.business.abstracts.SystemPersonnelService;
import ilayda.hrms.core.utilities.result.DataResult;
import ilayda.hrms.core.utilities.result.Result;
import ilayda.hrms.core.utilities.result.SuccessDataResult;
import ilayda.hrms.core.utilities.result.SuccessResult;
import ilayda.hrms.dataAccess.abstracts.SystemPersonnelDao;
import ilayda.hrms.entities.concretes.SystemPersonnel;

@Service
public class SystemPersonnelManager implements SystemPersonnelService {
	
	private SystemPersonnelDao personnelDao;
	
	@Autowired
	public SystemPersonnelManager(SystemPersonnelDao personnelDao) {
		super();
		this.personnelDao = personnelDao;
	}

	@Override
	public DataResult<List<SystemPersonnel>> getAll() {
		return new SuccessDataResult<List<SystemPersonnel>>(this.personnelDao.findAll(),"Sistem Personeleri Listelendi");
	}

	@Override
	public Result add(SystemPersonnel personnel) {
		
			
			this.personnelDao.save(personnel);
			
			return new SuccessResult("Sistem Personeli Eklendi");
		}
		

	@Override
	public Result delete(SystemPersonnel personnel) {
		this.personnelDao.delete(personnel);
		return new SuccessResult("Personel Silindi");
		
	}

	@Override
	public Result update(SystemPersonnel personnel) {
		this.personnelDao.save(personnel);
		return new SuccessResult("Personel Güncellendi");
		
	}

	

	

}

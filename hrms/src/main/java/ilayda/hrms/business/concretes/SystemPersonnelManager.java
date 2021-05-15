package ilayda.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ilayda.hrms.business.abstracts.SystemPersonnelService;
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
	public List<SystemPersonnel> getAll() {
		return this.personnelDao.findAll();
	}

	@Override
	public void add(SystemPersonnel personnel) {
		if(personnel.getFirstName()!=null && personnel.getLastName()!=null
				&& personnel.getEmail()!=null) {
			this.personnelDao.save(personnel);
		}else {
			return;
		}
		
		
	}

	@Override
	public void delete(SystemPersonnel personnel) {
		this.personnelDao.delete(personnel);
		
	}

	@Override
	public void update(SystemPersonnel personnel) {
		this.personnelDao.save(personnel);
		
	}

}

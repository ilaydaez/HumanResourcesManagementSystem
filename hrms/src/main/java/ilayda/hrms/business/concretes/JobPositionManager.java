package ilayda.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ilayda.hrms.business.abstracts.JobPositionService;
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
	public List<JobPosition> getAll() {
		return this.positionDao.findAll();
	}

	@Override
	public void add(JobPosition position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(JobPosition position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(JobPosition position) {
		// TODO Auto-generated method stub
		
	}

}

package ilayda.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ilayda.hrms.entities.concretes.JobAdversiment;

public interface JobAdversimentDao extends JpaRepository<JobAdversiment, Integer>{

	@Query("From JobAdversiment where isActive=true")
	List<JobAdversiment> getByIsActive();
	
	List<JobAdversiment> getByEmployer_CompanyNameAndIsActiveTrue(String companyName);
	
	JobAdversiment getByAdversimentId(int id);

}

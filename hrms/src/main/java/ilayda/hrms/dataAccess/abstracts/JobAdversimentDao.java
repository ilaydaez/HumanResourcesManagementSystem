package ilayda.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ilayda.hrms.entities.concretes.Employer;
import ilayda.hrms.entities.concretes.JobAdversiment;

public interface JobAdversimentDao extends JpaRepository<JobAdversiment, Integer>{
	
	List<JobAdversiment> getByIsActive(boolean active);
	List<JobAdversiment> getByListingDateAfter(LocalDate listingDate);
	List<JobAdversiment> getByEmployerAndIsActive(String employer, boolean active);

}

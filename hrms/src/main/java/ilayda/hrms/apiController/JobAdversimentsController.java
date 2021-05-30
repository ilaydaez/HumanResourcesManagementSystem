package ilayda.hrms.apiController;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ilayda.hrms.business.abstracts.JobAdversimentService;
import ilayda.hrms.core.utilities.result.DataResult;
import ilayda.hrms.core.utilities.result.Result;
import ilayda.hrms.entities.concretes.JobAdversiment;

@RestController
@RequestMapping("/api/jobAdversiments")
public class JobAdversimentsController {
	
	private JobAdversimentService adversimentService;

	@Autowired
	public JobAdversimentsController(JobAdversimentService adversimentService) {
		super();
		this.adversimentService = adversimentService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdversiment>> getAll(){
		return this.adversimentService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdversiment adversiment) {
		return this.adversimentService.add(adversiment);
	}
	
	@GetMapping("/getByIsActive")
	public DataResult<List<JobAdversiment>> getByIsActive(boolean active){
		return this.adversimentService.getByIsActive(active);
	}
	
	@GetMapping("/getByListingDate")
	public DataResult<List<JobAdversiment>> getByListingDateAfter(LocalDate listingDate){
		return this.adversimentService.getByListingDateAfter(listingDate);
	}
	
	@GetMapping("/getByEmployerAndIsActive")
	public DataResult<List<JobAdversiment>> getByEmployerAndIsActive(String employer, boolean active){
		return this.adversimentService.getByEmployerAndIsActive(employer,active);
	}
	

}

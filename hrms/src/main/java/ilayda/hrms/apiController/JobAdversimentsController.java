package ilayda.hrms.apiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/getByAdversimentId")
	public DataResult<JobAdversiment> getByAdversimentId(int id){
		return this.adversimentService.getByAdversimentId(id);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdversiment adversiment) {
		return this.adversimentService.add(adversiment);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody JobAdversiment adversiment) {
		return this.adversimentService.update(adversiment);
	}
	
	@PostMapping("/changeOpenToClose")
	public Result changeOpenToClose(int id) {
		return this.adversimentService.changeOpenToClose(id);
	}
	
	@GetMapping("/getByIsActive")
	public DataResult<List<JobAdversiment>> getByIsActive(){
		return this.adversimentService.getByIsActive();
	}
	
	@GetMapping("/getAllSorted")
	public DataResult<List<JobAdversiment>> getAllSorted(){
		return this.adversimentService.getAllSorted();
	}
	
	@GetMapping("/getByEmployer_CompanyNameAndIsActiveTrue")
	public DataResult<List<JobAdversiment>> getByEmployer_CompanyNameAndIsActiveTrue(@RequestParam("company_name") String companyName){
		return this.adversimentService.getByEmployer_CompanyNameAndIsActiveTrue(companyName);
	}
	

}

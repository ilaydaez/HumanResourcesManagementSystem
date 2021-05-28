package ilayda.hrms.apiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ilayda.hrms.business.abstracts.JobPositionService;
import ilayda.hrms.core.utilities.result.DataResult;
import ilayda.hrms.core.utilities.result.Result;
import ilayda.hrms.entities.concretes.JobPosition;


@RestController
@RequestMapping("/api/positions")
public class JobPositionsController {
	
	private JobPositionService positionService;

	@Autowired
	public JobPositionsController(JobPositionService positionService) {
		super();
		this.positionService = positionService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPosition>> getAll(){
		return this.positionService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPosition position) {
		return this.positionService.add(position);
	}
	

}

package ilayda.hrms.apiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ilayda.hrms.business.abstracts.SystemPersonnelService;
import ilayda.hrms.core.utilities.result.DataResult;
import ilayda.hrms.core.utilities.result.Result;
import ilayda.hrms.entities.concretes.SystemPersonnel;


@RestController
@RequestMapping("/api/personnels")
public class SystemPersonnelsController {
	
	private SystemPersonnelService personnelService;

	@Autowired
	public SystemPersonnelsController(SystemPersonnelService personnelService) {
		super();
		this.personnelService = personnelService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<SystemPersonnel>> getAll(){
		return this.personnelService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody SystemPersonnel personnel) {
		return this.personnelService.add(personnel);
	}

}

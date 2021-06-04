package ilayda.hrms.apiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ilayda.hrms.business.abstracts.CreateCvSrevice;
import ilayda.hrms.core.utilities.result.DataResult;
import ilayda.hrms.entities.concretes.CreateCv;

@RestController
@RequestMapping("/api/createCvs")
public class CreateCvsController {
	
	private CreateCvSrevice cvService;

	@Autowired
	public CreateCvsController(CreateCvSrevice cvService) {
		super();
		this.cvService = cvService;
	}
	
	@PostMapping("/add")
	public void addCv(@RequestBody CreateCv cv) {
		this.cvService.addCv(cv);	
	}

	
	@GetMapping("/getall")
	public DataResult<List<CreateCv>> getAll(){
		return this.cvService.getAll();
	}

}

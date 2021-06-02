package ilayda.hrms.apiController;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping("/insertCreateCv")
	public void insertCreateCv(@RequestParam String  firstName, @RequestParam String lastName,@RequestParam Date birthDate,@RequestParam String schoolName,
			@RequestParam String facultyName,@RequestParam String departmentName,@RequestParam Date schoolStartDate,@RequestParam Date schoolFinishDate,@RequestParam String companyName,
			@RequestParam String position,@RequestParam Date jobStartDate,@RequestParam Date jobFinishDate,@RequestParam String language,@RequestParam int languageLevel,@RequestParam String github,
			@RequestParam String linkedin,@RequestParam String programName) {
		this.cvService.insertCreateCv(firstName, lastName, birthDate, 
				schoolName, facultyName, departmentName, schoolStartDate, schoolFinishDate, 
				companyName, position, jobStartDate, jobFinishDate, 
				language, languageLevel, github, linkedin, programName);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CreateCv>> getAll(){
		return this.cvService.getAll();
	}

}

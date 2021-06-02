package ilayda.hrms.business.abstracts;

import java.util.Date;
import java.util.List;

import ilayda.hrms.core.utilities.result.DataResult;
import ilayda.hrms.core.utilities.result.Result;
import ilayda.hrms.entities.concretes.CreateCv;

public interface CreateCvSrevice {
	
	Result addCv(CreateCv cv);
	
	DataResult<List<CreateCv>> getAll();
	
	Result insertCreateCv(String firstName, String lastName,Date birthDate,
			String schoolName,String facultyName,String departmentName,
			Date schoolStartDate,Date schoolFinishDate,
			String companyName,String position,Date jobStartDate,Date jobFinishDate,
			String language,int languageLevel,
			String github,String linkedin,
			String programName);

}

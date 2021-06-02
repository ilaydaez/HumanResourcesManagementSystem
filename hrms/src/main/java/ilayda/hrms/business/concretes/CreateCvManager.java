package ilayda.hrms.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ilayda.hrms.business.abstracts.CreateCvSrevice;
import ilayda.hrms.core.utilities.result.DataResult;
import ilayda.hrms.core.utilities.result.Result;
import ilayda.hrms.core.utilities.result.SuccessDataResult;
import ilayda.hrms.core.utilities.result.SuccessResult;
import ilayda.hrms.dataAccess.abstracts.CreateCvDao;
import ilayda.hrms.entities.concretes.CreateCv;

@Service
public class CreateCvManager implements CreateCvSrevice{
	
	private CreateCvDao cvDao;

	@Autowired
	public CreateCvManager(CreateCvDao cvDao) {
		super();
		this.cvDao = cvDao;
	}

	@Override
	public Result addCv(CreateCv cv) {
		
		if(cv.getSchoolFinishDate()==null) {
			return new SuccessResult("Hala Okuyor.");
		}if(cv.getJobFinishDate()==null) {
			return new SuccessResult("Hala Çalışıyor.");
		}
		
		this.cvDao.save(cv);
		return new SuccessResult("Cv eklendi");
	}

	@Override
	public DataResult<List<CreateCv>> getAll() {
		return new SuccessDataResult<List<CreateCv>>(this.cvDao.findAll(),"Cv Listelendi");
	}

	@Override
	public Result insertCreateCv(String firstName, String lastName, Date birthDate, String schoolName,
			String facultyName, String departmentName, Date schoolStartDate, Date schoolFinishDate, String companyName,
			String position, Date jobStartDate, Date jobFinishDate, String language, int languageLevel, String github,
			String linkedin, String programName) {
		this.cvDao.insertCreateCv(firstName, lastName, birthDate, 
				schoolName, facultyName, departmentName, schoolStartDate, schoolFinishDate, 
				companyName, position, jobStartDate, jobFinishDate, language, languageLevel, 
				github, linkedin, programName);
		return new SuccessResult("Cv Oluşturuldu");
	}

}

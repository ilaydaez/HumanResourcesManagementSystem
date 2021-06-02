package ilayda.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCVDto {
	
	private int cvId;
	private int id;
	
	//school
	private int schoolId;
	private String schoolName;
	
	private int facultyId;
	private String facultyName;
	
	private int departmentId;
	private String departmentName;
	
	private Date schoolStartDate;
	private Date schoolFinishDate;
	
	//is tecrubeleri
	
	private String companyName;
	private int positionId;
	private String position;
	
	private Date jobStartDate;
	private Date jobFinishDate;
	
	//yabancı dil
	
	private int languageId;
	private String language;
	private int languageLevel;
	
	//fotograf
	
	private int imageId;
	private String imagePath;
	
	//adresler
	
	private String github;
	private String linkedin;
	
	//program
	
	private int programId;
	private String programName;
	
	//önyazı
	
	private String coverLetter;

}

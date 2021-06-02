package ilayda.hrms.dataAccess.abstracts;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ilayda.hrms.entities.concretes.CreateCv;

public interface CreateCvDao extends JpaRepository<CreateCv, Integer>{

	@Modifying
	@Query(value = "insert into CreateCv (firstName, lastName, birthDate, "
			+ "schoolName, facultyName, departmentName, schoolStartDate, schoolFinishDate,"
			+ "companyName, position, jobStartDate, jobFinishDate,"
			+ "language, languageLevel, github, linkedin, programName) "
			+ "values (:firstName, :lastName, :birthDate,"
			+ ":schoolName, :facultyName, :departmentName, :schoolStartDate, :schoolFinishDate,"
			+ ":companyName, :position, :jobStartDate, :jobFinishDate,"
			+ ":language, :languageLevel, :github, :linkedin, :programName)",
	  nativeQuery = true)
	void insertCreateCv(@Param("firstName") String firstName, @Param("lastName") String lastName,@Param("birthDate") Date birthDate,
			@Param("schoolName") String schoolName,@Param("facultyName")String  facultyName,@Param("departmentName") String departmentName,
			@Param("schoolStartDate") Date schoolStartDate,@Param("schoolFinishDate") Date schoolFinishDate,
			@Param("companyName") String companyName,@Param("position") String position,@Param("jobStartDate") Date jobStartDate,@Param("jobFinishDate") Date jobFinishDate,
			@Param("language") String language,@Param("languageLevel") int languageLevel,
			@Param("github") String github,@Param("linkedin") String linkedin,
			@Param("programName") String programName);
	
	

}

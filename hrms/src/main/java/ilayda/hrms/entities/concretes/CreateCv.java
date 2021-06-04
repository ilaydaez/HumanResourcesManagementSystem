package ilayda.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="create_cvs")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employee"})
public class CreateCv {
	
	//primaryKey
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cv_id")
	private int cvId;
	
	//foreignKey
	
	@ManyToOne()
	@JoinColumn(name = "id")
	private Employee employee;
	
	@OneToMany(mappedBy = "cvSchool")
	private List<School> schools;
	
	@OneToMany(mappedBy = "cvProgram")
	private List<Programming> programmings;
	
	@OneToMany(mappedBy = "cvLanguage")
	private List<ForeignLanguage> languages;
	
	@OneToMany(mappedBy = "cv")
	private List<Image> images;
	
	
	//Okul bilgisi
	
	@Column(name="school_start_date")
	private Date schoolStartDate;
	
	@Column(name="school_finish_date")
	private Date schoolFinishDate;
	
	//iş tecrübesi
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="job_start_date")
	private Date jobStartDate;
	
	@Column(name="job_finish_date")
	private Date jobFinishDate;
	
	@Column(name="job_description")
	private String jobDescription;
	
	//ek bilgiler
	
	@Column(name="language_level")
	private int languageLevel;
	
	@Column(name="github")
	private String github;
	
	@Column(name="linkedin")
	private String linkedin;
	
	@Column(name="cover_letter")
	private String coverLetter;

}

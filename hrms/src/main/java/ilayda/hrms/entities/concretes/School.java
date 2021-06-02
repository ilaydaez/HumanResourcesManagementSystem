package ilayda.hrms.entities.concretes;

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
@Table(name = "schools")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cvSchool"})
public class School {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "school_id")
	private int schoolId;
	
	@Column(name = "school_name")
	private String schoolName;

	//foreignKey
	
	@OneToMany(mappedBy = "school")
	private List<Faculty> faculties;
	
	@ManyToOne()
	@JoinColumn(name = "cv_id")
	private CreateCv cvSchool;

}

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
@Table(name = "faculties")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler", "school"})
public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "faculty_id")
	private int facultyId;
	
	@Column(name = "faculty_name")
	private String facultyName;
	
	@ManyToOne()
	@JoinColumn(name = "school_id")
	private School school;
	
	@OneToMany(mappedBy = "faculty")
	private List<Department> departments;

}

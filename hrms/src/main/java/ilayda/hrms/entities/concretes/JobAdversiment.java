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
@Table(name ="job_adversiments")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employer"})
public class JobAdversiment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="adversiment_id")
	private int adversimentId;
	
	@ManyToOne()
	@JoinColumn(name="position")
	private JobPosition position;
	
	@OneToMany(mappedBy = "jobAdversiment")
	private List<City> cities;
	
	@Column(name="description")
	private String description;
	
	@Column(name="min_salary")
	private double minSalary;
	
	@Column(name="max_salary")
	private double maxSalary;
	
	@Column(name="open_position")
	private int openPosition;
	
	@Column(name="application_deadline")
	private Date applicationDeadline;
	
	@Column(name="is_active")
	private boolean isActive;

	@Column(name="listing_date")
	private Date listingDate;
	
	
	@ManyToOne()
	@JoinColumn(name="id")
	private Employer employer;

}

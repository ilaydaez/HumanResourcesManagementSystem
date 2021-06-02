package ilayda.hrms.entities.concretes;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name ="employers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","adversiments"})
public class Employer extends User {
	

	@Column(name="company_name")
	private String companyName;
	
	@Column(name="phone")
	private String phone;
	
	@OneToMany(mappedBy = "employer")
	private List<JobAdversiment> adversiments;

}

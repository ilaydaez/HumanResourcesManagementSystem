package ilayda.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="employers")
public class Employer extends User {
	

	@Column(name="company_name")
	private String companyName;
	
	@Column(name="phone")
	private String phone;
	
	@OneToMany(mappedBy = "employer")
	private List<JobAdversiment> adversiments;


	public Employer(String companyName, String website, String phone) {
		super();
		this.companyName = companyName;
		this.phone = phone;
	}
	
	public Employer() {}



	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	

}

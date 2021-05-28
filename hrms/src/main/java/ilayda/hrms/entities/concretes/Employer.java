package ilayda.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="employers")
public class Employer extends User {
	

	@Column(name="company_name")
	private String companyName;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="positionId")
	private int positionId;


	public Employer(String companyName, String website, String phone, int positionId) {
		super();
		this.companyName = companyName;
		this.phone = phone;
		this.positionId=positionId;
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
	
	
	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}
	

}

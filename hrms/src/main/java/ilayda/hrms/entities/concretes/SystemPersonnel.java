package ilayda.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="system_personnels")
public class SystemPersonnel extends User{

	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	public SystemPersonnel( String firstName, String lastName) {
		super();

		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public SystemPersonnel() {}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}

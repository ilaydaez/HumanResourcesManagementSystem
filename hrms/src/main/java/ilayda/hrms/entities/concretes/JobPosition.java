package ilayda.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name ="job_positions")
public class JobPosition {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="position")
	private String position;
	
	public JobPosition(int id, String position) {
		super();
		this.id = id;
		this.position = position;
	}
	
	public JobPosition() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}

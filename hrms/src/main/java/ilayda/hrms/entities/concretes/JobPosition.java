package ilayda.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="job_positions")
public class JobPosition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="position_id")
	private int positionId;
	
	@Column(name="position")
	private String position;
	
	@OneToMany(mappedBy = "position")
	private List<JobAdversiment> jobAdversiments;

	
	public JobPosition(int positionId, String position) {
		super();
		this.positionId = positionId;
		this.position = position;
	}
	
	public JobPosition() {}

	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}

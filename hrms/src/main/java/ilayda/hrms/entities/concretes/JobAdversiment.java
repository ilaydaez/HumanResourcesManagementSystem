package ilayda.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="job_adversiments")
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
	
	public JobAdversiment() {
		super();
	}


	public JobAdversiment(int adversimentId, String description, double minSalary, double maxSalary,
			int openPosition, Date applicationDeadline, boolean isActive, Date listingDate) {
		super();
		this.adversimentId = adversimentId;
		this.description = description;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.openPosition = openPosition;
		this.applicationDeadline = applicationDeadline;
		this.isActive=isActive;
		this.listingDate=listingDate;
	}

	
	public JobAdversiment(boolean isActive, Date listingDate) {
		this.isActive=isActive;
		this.listingDate=listingDate;
	}

	public int getAdversimentId() {
		return adversimentId;
	}

	public void setAdversimentId(int adversimentId) {
		this.adversimentId = adversimentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(double minSalary) {
		this.minSalary = minSalary;
	}

	public double getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(double maxSalary) {
		this.maxSalary = maxSalary;
	}

	public int getOpenPosition() {
		return openPosition;
	}

	public void setOpenPosition(int openPosition) {
		this.openPosition = openPosition;
	}

	public Date getApplicationDeadline() {
		return applicationDeadline;
	}

	public void setApplicationDeadline(Date applicationDeadline) {
		this.applicationDeadline = applicationDeadline;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getListingDate() {
		return listingDate;
	}
	
	
	public void setListingDate(Date listingDate) {
		this.listingDate = listingDate;
	}

}

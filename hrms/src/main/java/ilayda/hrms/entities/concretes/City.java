package ilayda.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="cities")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler", "jobAdversiment", "employee"})
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="city_id")
	private int cityId;
	
	@Column(name="city")
	private String city;
	
	@ManyToOne()
	@JoinColumn(name="adversiment_id")
	private JobAdversiment jobAdversiment;
	
	@ManyToOne()
	@JoinColumn(name="id")
	private Employee employee;

}

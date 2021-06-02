package ilayda.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="system_personnels")
public class SystemPersonnel extends User{

	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

}

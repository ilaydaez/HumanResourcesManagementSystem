package ilayda.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employees")
public class Employee extends User {


	@Column(name="first_name")
	@NotBlank
	@NotNull
	private String firstName;
	
	@Column(name="last_name")
	@NotBlank
	@NotNull
	private String lastName;
	
	@Column(name="identity_number")
	@NotBlank
	@NotNull
	private String identityNumber;
	
	@Column(name="birth_date")
	private Date birthDate;
	
	@OneToMany(mappedBy = "employee")
	private List<CreateCv> cvs;
	
	
	@OneToMany(mappedBy = "employee")
	private List<City> cities;
	
}

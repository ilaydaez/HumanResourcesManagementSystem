package ilayda.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ilayda.hrms.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	
	Employee findUserByEmail(String email);

}

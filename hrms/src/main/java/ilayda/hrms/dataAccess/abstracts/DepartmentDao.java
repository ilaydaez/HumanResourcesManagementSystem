package ilayda.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ilayda.hrms.entities.concretes.Department;

public interface DepartmentDao extends JpaRepository<Department, Integer>{

}

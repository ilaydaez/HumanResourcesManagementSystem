package ilayda.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ilayda.hrms.entities.concretes.Faculty;

public interface FacultyDao extends JpaRepository<Faculty, Integer>{


}

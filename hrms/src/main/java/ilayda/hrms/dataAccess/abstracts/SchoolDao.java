package ilayda.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ilayda.hrms.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer>{

}

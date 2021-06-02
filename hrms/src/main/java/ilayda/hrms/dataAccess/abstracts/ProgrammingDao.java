package ilayda.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ilayda.hrms.entities.concretes.Programming;

public interface ProgrammingDao extends JpaRepository<Programming, Integer>{

}

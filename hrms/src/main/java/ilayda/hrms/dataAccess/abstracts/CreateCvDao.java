package ilayda.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ilayda.hrms.entities.concretes.CreateCv;

public interface CreateCvDao extends JpaRepository<CreateCv, Integer>{
	
	CreateCv getByCvId(int id);
}

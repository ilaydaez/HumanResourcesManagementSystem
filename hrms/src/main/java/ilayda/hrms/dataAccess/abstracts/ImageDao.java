package ilayda.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import ilayda.hrms.entities.concretes.Image;

public interface ImageDao extends JpaRepository<Image, Integer>{
	
	Image getByImageId(int imageId);

}

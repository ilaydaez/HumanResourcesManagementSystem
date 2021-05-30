package ilayda.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ilayda.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {

}

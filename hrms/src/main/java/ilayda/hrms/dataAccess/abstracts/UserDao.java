package ilayda.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ilayda.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {

	User findUserByEmail(String email);
}

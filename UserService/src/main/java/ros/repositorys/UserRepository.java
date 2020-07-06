package ros.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ros.models.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{

}

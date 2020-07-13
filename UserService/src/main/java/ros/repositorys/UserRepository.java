package ros.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ros.models.User;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{

    List<User> findByStore(long id);

    List<User> findByStoreCompany(long id);
}

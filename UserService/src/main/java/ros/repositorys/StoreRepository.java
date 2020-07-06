package ros.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ros.models.Store;

@Repository
public interface StoreRepository  extends JpaRepository<Store, Long>{

}

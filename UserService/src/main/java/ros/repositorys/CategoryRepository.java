package ros.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ros.models.Category;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Long>{

}

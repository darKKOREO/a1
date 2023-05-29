package sit.thinktaegeb.mybackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.thinktaegeb.mybackend.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
}

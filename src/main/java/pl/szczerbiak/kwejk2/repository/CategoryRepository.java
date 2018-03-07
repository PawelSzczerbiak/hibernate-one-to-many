package pl.szczerbiak.kwejk2.repository;

import org.springframework.data.repository.CrudRepository;
import pl.szczerbiak.kwejk2.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}

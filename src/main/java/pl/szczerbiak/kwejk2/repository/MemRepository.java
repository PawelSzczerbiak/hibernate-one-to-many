package pl.szczerbiak.kwejk2.repository;

import org.springframework.data.repository.CrudRepository;
import pl.szczerbiak.kwejk2.model.Mem;

public interface MemRepository extends CrudRepository<Mem, Long> {
}

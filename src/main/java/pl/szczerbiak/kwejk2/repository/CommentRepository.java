package pl.szczerbiak.kwejk2.repository;

import org.springframework.data.repository.CrudRepository;
import pl.szczerbiak.kwejk2.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}

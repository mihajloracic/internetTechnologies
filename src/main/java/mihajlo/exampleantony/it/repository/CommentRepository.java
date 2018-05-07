package mihajlo.exampleantony.it.repository;

import mihajlo.exampleantony.it.entity.Comment;
import mihajlo.exampleantony.it.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> getCommentByPlace(Place place);
}

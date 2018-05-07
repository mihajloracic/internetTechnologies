package mihajlo.exampleantony.it.repository;

import mihajlo.exampleantony.it.entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<Poll,Long> {

}

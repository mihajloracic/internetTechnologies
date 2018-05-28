package mihajlo.exampleantony.it.repository;

import mihajlo.exampleantony.it.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote,Long> {
}

package mihajlo.exampleantony.it.repository;

import mihajlo.exampleantony.it.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByUsername(String username);
}

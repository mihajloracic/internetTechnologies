package mihajlo.exampleantony.it.repository;

import mihajlo.exampleantony.it.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}

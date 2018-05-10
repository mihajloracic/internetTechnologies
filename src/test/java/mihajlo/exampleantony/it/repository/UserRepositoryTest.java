package mihajlo.exampleantony.it.repository;

import mihajlo.exampleantony.it.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepositoryForTest userRepositoryForTest;

    @Test
    public void contextLoads() {
    }
    @Test
    public void repositoryInit(){
        if(userRepositoryForTest == null){
            assertThat(userRepositoryForTest).isNotNull();
        }
    }
    @Test
    public void saveUser(){
        User u = new User("mihajlo","123","mihajlo.rac@gmail.com","mihajlo","racic");
        userRepositoryForTest.save(u);
        assertThat(u.getId()).isNotNull();
        Long savedUserId = u.getId();
        u = userRepositoryForTest.findById(savedUserId);
        assertThat(u.getEmail().equals("mihajlo.rac@gmail.com"));
        assertThat(userRepositoryForTest.findByUsername("m1") != null);
    }
    @Test
    public void multypleUserCreate(){
        User u = new User("mihajlo3","123","mihajlo.rac3@gmail.com","mihajlo","racic");
        User u2 = new User("mihajlo2","123","mihajlo.rac2@gmail.com","mihajlo","racic");
        userRepositoryForTest.save(u);
        userRepositoryForTest.save(u2);
    }
}

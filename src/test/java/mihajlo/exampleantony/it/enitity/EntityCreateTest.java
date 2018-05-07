package mihajlo.exampleantony.it.enitity;

import mihajlo.exampleantony.it.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntityCreateTest {
    @Test
    public void contextLoads() {
        User u = new User();
        Place p = new Place();
        Rating r = new Rating();
        Comment comment = new Comment();
        Poll poll = new Poll();
    }

}

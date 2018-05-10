package mihajlo.exampleantony.it.repository;

import mihajlo.exampleantony.it.entity.Place;
import mihajlo.exampleantony.it.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlaceRepositoryTest {
    @Autowired
    PlaceRepository placeRepository;
    @Autowired
    UserRepositoryForTest userRepositoryForTest;

    @Test
    public void repositoryInit(){
        assertThat(placeRepository).isNotNull();
    }

    @Test
    public void saveGetPlaces(){
        User u = new User("unique","123","unique.rac@gmail.com","mihajlo","racic");
        Place p = new Place("lepo mesto","","",123.0,123,"","",u);
        Place p2 = new Place("jos jedno mesto","","",123.0,123,"","",u);
        userRepositoryForTest.save(u);
        placeRepository.save(p);
        placeRepository.save(p2);

    }

    @Test
    @Transactional
    public void doPlacesGetConnectedWithUser(){
        User u = userRepositoryForTest.findByUsername("unique").get(0);
        List<Place> places = userRepositoryForTest.findById(u.getId()).getMyPlaces();
        assert u.getMyPlaces().size() >= 2;
    }
}

package mihajlo.exampleantony.it.repository;

import mihajlo.exampleantony.it.entity.Place;
import mihajlo.exampleantony.it.entity.User;
import mihajlo.exampleantony.it.service.MockDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RatingRepositroyTest {

    @Autowired
    RatingRepository ratingRepository;

    @Autowired
    MockDataService mockDataService;
    @Autowired
    UserRepositoryForTest userRepositoryForTest;
    @Autowired
    PlaceRepository placeRepository;

    @Test
    public void getRatingForPlace(){
        mockDataService.populateData();
        Place place = placeRepository.findByName("test1").get(0);
         assert ratingRepository.getRatingByPlace(place).size() == 2;
    }

    @Test
    public void getRatingForUserAndPlace(){
        mockDataService.populateData();
        Place place = placeRepository.findByName("test1").get(0);
        User user = userRepositoryForTest.findByUsername("m2").get(0);
        assert ratingRepository.getRatingByPlaceAndUser(place,user).size() == 1;
        mockDataService.populateData();
    }



}

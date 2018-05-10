package mihajlo.exampleantony.it.service;

import mihajlo.exampleantony.it.entity.Place;
import mihajlo.exampleantony.it.entity.User;
import mihajlo.exampleantony.it.entity.dto.RatingDTO;
import mihajlo.exampleantony.it.repository.PlaceRepository;
import mihajlo.exampleantony.it.repository.RatingRepository;
import mihajlo.exampleantony.it.repository.UserRepositoryForTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RatingServiceTest {
    @Autowired
    RatingRepository ratingRepository;
    @Autowired
    MockDataService mockDataService;
    @Autowired
    UserRepositoryForTest userRepositoryForTest;
    @Autowired
    PlaceRepository placeRepository;
    @Autowired
    RatingService ratingService;
    @Test
    public void getRating(){
        mockDataService.populateData();
        Place place = placeRepository.findByName("test1").get(0);
        assert ratingService.getAverageRating(place) == 4;
    }
    @Test
    public void addOneRatting(){
        mockDataService.populateData();
        Place place = placeRepository.findByName("test2").get(0);
        User user = userRepositoryForTest.findByUsername("RatingTestUser").get(0);
        RatingDTO dto1 = new RatingDTO(user.getId(),place.getId(),5);
        ratingService.addRating(dto1, user);
        assert ratingRepository.getRatingByPlaceAndUser(place,user).size() == 1;
    }

    @Test
    public void changeRating(){
        mockDataService.populateData();
        Place place = placeRepository.findByName("test3").get(0);
        User user = userRepositoryForTest.findByUsername("RatingTestUser").get(0);
        RatingDTO dto1 = new RatingDTO(user.getId(),place.getId(),5);
        ratingService.addRating(dto1, user);
        assert ratingRepository.getRatingByPlaceAndUser(place,user).size() == 1;
        dto1 = new RatingDTO(user.getId(),place.getId(),4);
        ratingService.addRating(dto1, user);
        assert ratingRepository.getRatingByPlaceAndUser(place,user).size() == 1;
        assert ratingService.getAverageRating(place) == 4;
    }
}

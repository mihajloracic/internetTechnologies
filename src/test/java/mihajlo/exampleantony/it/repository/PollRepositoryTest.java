package mihajlo.exampleantony.it.repository;

import mihajlo.exampleantony.it.entity.Place;
import mihajlo.exampleantony.it.entity.Poll;
import mihajlo.exampleantony.it.entity.User;
import mihajlo.exampleantony.it.service.MockDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PollRepositoryTest {
    @Autowired
    MockDataService mockDataService;
    @Autowired
    PollRepository pollRepository;
    @Autowired
    UserRepositoryForTest userRepositoryForTest;
    @Autowired
    PlaceRepository placeRepository;


    @Test
    @Transactional
    public void addPlaceToPoll(){
        mockDataService.populateData();
        User user = userRepositoryForTest.findByUsername("m1").get(0);
        Poll poll = pollRepository.save(new Poll(new Date(123),user,"this is gonna be an epic night!"));
        Long pollId = poll.getId();
        Place place = placeRepository.findByName("Bo").get(0);
        Place place2 = placeRepository.findByName("Bo2").get(0);
        poll.getPlaces().add(place);
        poll.getPlaces().add(place2);
        pollRepository.save(poll);
        poll = pollRepository.getOne(pollId);
        assert poll.getPlaces().contains(place);
        assert poll.getPlaces().contains(place2);

    }

}

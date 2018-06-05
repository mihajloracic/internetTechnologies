package mihajlo.exampleantony.it.service;

import mihajlo.exampleantony.it.entity.Place;
import mihajlo.exampleantony.it.entity.Poll;
import mihajlo.exampleantony.it.entity.User;
import mihajlo.exampleantony.it.repository.PlaceRepository;
import mihajlo.exampleantony.it.repository.PollRepository;
import mihajlo.exampleantony.it.repository.UserRepository;
import mihajlo.exampleantony.it.repository.VoteRepository;
import mihajlo.exampleantony.it.service.voting.PollService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VotingServiceTest {

    @Autowired
    VoteRepository voteRepository;
    @Autowired
    PollRepository pollRepository;
    @Autowired
    PollService pollService;
    @Autowired
    MockDataService mockDataService;
    @Autowired
    PlaceRepository placeRepository;
    @Autowired
    UserRepository userRepository;
    @PersistenceContext
    private EntityManager em;
    @Test
    public void addUserToPoll(){
        mockDataService.populateData();
        Place place = placeRepository.findByName("test1").get(0);
        User user = userRepository.findByUsername("m1");
        Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        try {
            Poll poll = pollService.addPoll(new Poll(date,user,"cool voting"), user);
            poll.getUsers().add(user);
            poll.getPlaces().add(place);
            Poll poll2 = pollService.addPoll(poll,user);
            Long pol2Id = poll2.getId();
            int a = 2;
            getAllFieldsTest(pol2Id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Transactional
    public void getAllFieldsTest(Long id) throws DataAccessException {
        Poll poll3 = em.find(Poll.class, id);
        Set<User> users =  em.find(Poll.class, id).getUsers();
        int a = 2;
    }
    @Test
    public void addVode(){

    }
    @Test
    public void calculateResult(){

    }
}

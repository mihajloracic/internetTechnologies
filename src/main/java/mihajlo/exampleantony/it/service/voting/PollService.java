package mihajlo.exampleantony.it.service.voting;

import mihajlo.exampleantony.it.entity.Place;
import mihajlo.exampleantony.it.entity.Poll;
import mihajlo.exampleantony.it.entity.User;
import mihajlo.exampleantony.it.entity.Vote;
import mihajlo.exampleantony.it.repository.PlaceRepository;
import mihajlo.exampleantony.it.repository.PollRepository;
import mihajlo.exampleantony.it.repository.UserRepository;
import mihajlo.exampleantony.it.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;

@Service
public class PollService {
    @Autowired
    PollRepository pollRepository;

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    PlaceRepository placeRepository;


    public Poll addPoll(Poll poll,User user) throws Exception {
        if(poll.getUserCreated() == null){
            poll.setUserCreated(user);
        }
        if(!poll.getUserCreated().equals(user)){
            throw new Exception("Unauthorized");
        }
        return pollRepository.save(poll);
    }
    public Vote addVote(Vote vote, User user) throws Exception {
        if(vote.getUser() != null){
            vote.setUser(user);
        }
        if(!vote.getUser().equals(user)){
            throw new Exception("Unauthorized");
        }
        return voteRepository.save(vote);
    }
}

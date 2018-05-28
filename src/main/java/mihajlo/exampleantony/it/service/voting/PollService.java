package mihajlo.exampleantony.it.service.voting;

import mihajlo.exampleantony.it.entity.Poll;
import mihajlo.exampleantony.it.entity.User;
import mihajlo.exampleantony.it.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PollService {
    @Autowired
    PollRepository pollRepository;

    public Poll addPoll(Poll poll,User user) throws Exception {
        if(poll.getUserCreated() != null){
            poll.setUserCreated(user);
        }
        if(!poll.getUserCreated().equals(user)){
            throw new Exception("Unauthorized");
        }
        return pollRepository.save(poll);
    }
}

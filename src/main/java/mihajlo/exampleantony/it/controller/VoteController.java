package mihajlo.exampleantony.it.controller;

import mihajlo.exampleantony.it.entity.CustomUserDetail;
import mihajlo.exampleantony.it.entity.Poll;
import mihajlo.exampleantony.it.entity.User;
import mihajlo.exampleantony.it.entity.Vote;
import mihajlo.exampleantony.it.repository.PollRepository;
import mihajlo.exampleantony.it.service.UserService;
import mihajlo.exampleantony.it.service.voting.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoteController {

    @Autowired
    PollService pollService;

    @Autowired
    UserService userService;

    @Autowired
    PollRepository pollRepository;

    @PostMapping(value = "/pole")
    public Poll addPole(@RequestBody Poll poll) throws Exception {
        CustomUserDetail userDetail = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.getUser(userDetail);
        return  pollService.addPoll(poll,user);
    }

    @PostMapping(value = "/vote")
    public Vote addVote(@RequestBody Vote vote) throws Exception {
        CustomUserDetail userDetail = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.getUser(userDetail);
        return pollService.addVote(vote,user);
    }

    @GetMapping(value = "/pole")
    public List<Poll> getMyPoles(){
        //CustomUserDetail userDetail = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //User user = userService.getUser(userDetail);
        return pollRepository.findAll();
    }
}

package mihajlo.exampleantony.it.controller;

import mihajlo.exampleantony.it.entity.CustomUserDetail;
import mihajlo.exampleantony.it.entity.Place;
import mihajlo.exampleantony.it.entity.User;
import mihajlo.exampleantony.it.entity.dto.RatingDTO;
import mihajlo.exampleantony.it.service.RatingService;
import mihajlo.exampleantony.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingController {

    @Autowired
    UserService userService;
    @Autowired
    RatingService ratingService;

    @PostMapping(value = "/rating")
    public void addRating(RatingDTO ratingDTO){
        CustomUserDetail userDetail = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.getUser(userDetail);
        ratingService.addRating(ratingDTO,user);
    }

    @PostMapping(value = "/rating/get")
    public double getRatingForPlace(@RequestBody Place place){
        return ratingService.getAverageRating(place);
    }
}

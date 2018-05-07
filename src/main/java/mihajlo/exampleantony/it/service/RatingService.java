package mihajlo.exampleantony.it.service;

import mihajlo.exampleantony.it.entity.Place;
import mihajlo.exampleantony.it.entity.Rating;
import mihajlo.exampleantony.it.entity.User;
import mihajlo.exampleantony.it.entity.dto.RatingDTO;
import mihajlo.exampleantony.it.repository.PlaceRepository;
import mihajlo.exampleantony.it.repository.RatingRepository;
import mihajlo.exampleantony.it.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RatingRepository ratingRepository;
    @Autowired
    PlaceRepository placeRepository;

    public void addRating(RatingDTO ratingDTO, User user){
        Place place = placeRepository.getOne(ratingDTO.placeId);
        List<Rating> ratings = ratingRepository.getRatingByPlaceAndUser(place,user);
        if(0 > ratingDTO.value || ratingDTO.value > 5){
            return;
        }
        if(ratingDTO.userId != user.getId()){
            return;
        }
        if(ratings.size() != 0){
            Rating rating = ratings.get(0);
            rating.setValue(ratingDTO.value);
            ratingRepository.save(rating);
            return;
        }
        else{
            ratingRepository.save(new Rating(user,place,ratingDTO.value));
        }
    }
    public float getAverageRating(Place place){
        List<Rating> ratings =  ratingRepository.getRatingByPlace(place);
        if(ratings.size() == 0){
            return 0;
        }
        int sum = 0;
        for(Rating rating : ratings){
            sum += rating.getValue();
        }
        return  sum / ratings.size();
    }
}

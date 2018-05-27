package mihajlo.exampleantony.it.service.place;

import javassist.NotFoundException;
import mihajlo.exampleantony.it.entity.Place;
import mihajlo.exampleantony.it.entity.User;
import mihajlo.exampleantony.it.repository.PlaceRepository;
import mihajlo.exampleantony.it.repository.UserRepositoryForTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminPlaceService {

    @Autowired
    PlaceRepository placeRepository;
    @Autowired
    UserRepositoryForTest userRepositoryForTest;

    public Place save(Place place, User user) throws NotFoundException {
        place.setApproved(false);
        if(place.getUserCreated().getId() != user.getId()){
            throw new NotFoundException("Unauhorized action");
        }
        return placeRepository.save(place);
    }

    public List<Place> getMyPlaces(User user){
        return user.getMyPlaces();
    }
}

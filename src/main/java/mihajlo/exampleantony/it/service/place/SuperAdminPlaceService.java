package mihajlo.exampleantony.it.service.place;

import mihajlo.exampleantony.it.entity.Place;
import mihajlo.exampleantony.it.entity.User;
import mihajlo.exampleantony.it.repository.PlaceRepository;
import mihajlo.exampleantony.it.repository.UserRepositoryForTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperAdminPlaceService {

    @Autowired
    PlaceRepository placeRepository;

    @Autowired
    UserRepositoryForTest userRepositoryForTest;

    public List<Place> getUnapprovedPlaces(){
        return placeRepository.findUnapprovedPlaces();
    }

    public Place approvePlace(Place place, User user){
        //TODO check role super admin
        place.setApproved(true);
        return placeRepository.save(place);
    }

    public void deletePlace(Place place, User user){
        //TODO check role super admin
         placeRepository.delete(place);
    }
}

package mihajlo.exampleantony.it.service.place;

import mihajlo.exampleantony.it.entity.Place;
import mihajlo.exampleantony.it.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPlaceService {
    @Autowired
    PlaceRepository placeRepository;

    public List<Place> getAllPlaces(){
        return placeRepository.findApprovedPlaces();
    }

    public List<Place> getPlacesInCity(String city){
        return placeRepository.findApprovedPlacesInCity(city);
    }

    public List<Place> getPlacesByCityAndType(String city, String type){
        return placeRepository.findApprovedPlacesInCityAndType(city,type);
    }
}

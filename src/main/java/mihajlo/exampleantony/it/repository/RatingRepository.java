package mihajlo.exampleantony.it.repository;

import mihajlo.exampleantony.it.entity.Place;
import mihajlo.exampleantony.it.entity.Rating;
import mihajlo.exampleantony.it.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,Long> {
    public List<Rating> getRatingByPlace(Place place);
    public List<Rating> getRatingByPlaceAndUser(Place place, User user);
}

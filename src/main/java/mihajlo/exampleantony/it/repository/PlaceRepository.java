package mihajlo.exampleantony.it.repository;

import mihajlo.exampleantony.it.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place,Long> {
    List<Place> findByName(String name);

    @Query("select p from Place p where approved = false")
    List<Place> findUnapprovedPlaces();
    @Query("select p from Place p where approved = true")
    List<Place> findApprovedPlaces();
    @Query("select p from Place p where approved = true and p.city = :city")
    List<Place> findApprovedPlacesInCity(@Param("city") String city);
    @Query("select p from Place p where approved = true and p.city = :city and p.type = :type")
    List<Place> findApprovedPlacesInCityAndType(@Param("city") String city, @Param("type") String type);


}

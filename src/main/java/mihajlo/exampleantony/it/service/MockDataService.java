package mihajlo.exampleantony.it.service;

import mihajlo.exampleantony.it.entity.Comment;
import mihajlo.exampleantony.it.entity.Place;
import mihajlo.exampleantony.it.entity.Rating;
import mihajlo.exampleantony.it.entity.User;
import mihajlo.exampleantony.it.repository.CommentRepository;
import mihajlo.exampleantony.it.repository.PlaceRepository;
import mihajlo.exampleantony.it.repository.RatingRepository;
import mihajlo.exampleantony.it.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MockDataService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PlaceRepository placeRepository;

    @Autowired
    RatingRepository ratingRepository;

    @Autowired
    CommentRepository commentRepository;

    public void populateData(){
        if(userRepository.findByUsername("m1").size() == 0){
            User u = userRepository.save( new User("m1","123","m1.rac@gmail.com","mihajlo","racic"));
            User u2 = userRepository.save( new User("m2","123","m2.rac@gmail.com","mihajlo","racic"));
            User superAdmin = userRepository.save( new User("superadmin","123","super.rac@gmail.com","mihajlo","racic"));
            User testUser = userRepository.save( new User("testUser","123","testUser.rac@gmail.com","mihajlo","racic"));
            userRepository.save( new User("RatingTestUser","123","RatingTestUser.rac@gmail.com","mihajlo","racic"));
            userRepository.save( new User("m3","123","m3.rac@gmail.com","mihajlo","racic"));
            userRepository.save( new User("m4","123","m4.rac@gmail.com","mihajlo","racic"));
            userRepository.save(superAdmin);
            placeRepository.save(new Place("Bo","","",123.0,123,"Kaunas","pub",u));
            placeRepository.save(new Place("Bo2","","",123.0,123,"Kaunas","pub",u2));
            placeRepository.save(new Place("Bassement","","",123.0,123,"Kaunas","club",u));
            placeRepository.save(new Place("Jampub","","",123.0,123,"Kaunas","pub",u));
            placeRepository.save(new Place("Vilnus pub","","",123.0,123,"Vilnus","pub",u));
            Place place1 = new Place("test1","","",123.0,123,"test city","bar",testUser);
            Place place2 = new Place("test2","","",123.0,123,"test city","bar",testUser);
            Place place3 = new Place("test3","","",123.0,123,"test city","pub",testUser);
            place1.setApproved(true);
            place2.setApproved(true);
            place3.setApproved(true);
            placeRepository.save(place1);
            placeRepository.save(place2);
            placeRepository.save(place3);
            ratingRepository.save(new Rating(u,place1,5));
            ratingRepository.save(new Rating(u2,place1,3));
            Place commentPlace = new Place("comment place","","",123.0,123,"test city","pub",testUser);
            placeRepository.save(commentPlace);
            commentRepository.save(new Comment("this place sucks", u, commentPlace));
            commentRepository.save(new Comment("this place is great", u, commentPlace));
            commentRepository.save(new Comment("really hot waitress", u, commentPlace));
            Place commentServicePlace = new Place("comment service","","",123.0,123,"test city","pub",testUser);
            placeRepository.save(commentServicePlace);
        }
    }
}

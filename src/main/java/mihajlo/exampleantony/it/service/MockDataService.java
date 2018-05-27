package mihajlo.exampleantony.it.service;

import mihajlo.exampleantony.it.entity.Comment;
import mihajlo.exampleantony.it.entity.Place;
import mihajlo.exampleantony.it.entity.Rating;
import mihajlo.exampleantony.it.entity.User;
import mihajlo.exampleantony.it.repository.CommentRepository;
import mihajlo.exampleantony.it.repository.PlaceRepository;
import mihajlo.exampleantony.it.repository.RatingRepository;
import mihajlo.exampleantony.it.repository.UserRepositoryForTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MockDataService {

    @Autowired
    UserRepositoryForTest userRepositoryForTest;

    @Autowired
    PlaceRepository placeRepository;

    @Autowired
    RatingRepository ratingRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserService userService;

    @Transactional
    public void populateData(){
        commentRepository.deleteAll();
        ratingRepository.deleteAll();
        placeRepository.deleteAll();
        userRepositoryForTest.deleteAll();
        if(userRepositoryForTest.findByUsername("m1").size() == 0){
            User u = userRepositoryForTest.save( new User("m1","123","m1.rac@gmail.com","mihajlo","racic"));
            User u2 = userRepositoryForTest.save( new User("m2","123","m2.rac@gmail.com","mihajlo","racic"));
            User superAdmin = userRepositoryForTest.save( new User("superadmin","123","super.rac@gmail.com","mihajlo","racic"));
            User testUser = userRepositoryForTest.save( new User("testUser","123","testUser.rac@gmail.com","mihajlo","racic"));
            userRepositoryForTest.save( new User("RatingTestUser","123","RatingTestUser.rac@gmail.com","mihajlo","racic"));
            userRepositoryForTest.save( new User("m3","123","m3.rac@gmail.com","mihajlo","racic"));
            userRepositoryForTest.save( new User("m4","123","m4.rac@gmail.com","mihajlo","racic"));
            placeRepository.save(new Place("Bo","","https://scontent.fvno3-1.fna.fbcdn.net/v/t1.0-9/579437_455129381245760_892761155_n.jpg?_nc_cat=0&oh=3e8fe6fefdaf38bcca138363d4a14183&oe=5B89E664",123.0,123,"Kaunas","pub",u));
            Place bo = placeRepository.save(new Place("Bo2","orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scsed in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.","https://scontent.fvno3-1.fna.fbcdn.net/v/t1.0-9/579437_455129381245760_892761155_n.jpg?_nc_cat=0&oh=3e8fe6fefdaf38bcca138363d4a14183&oe=5B89E664",123.0,123,"Kaunas","pub",u2));
            Place bo2 = placeRepository.save(new Place("Bassement","orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.","http://renginiai.kasvyksta.lt/uploads/places/1745/BASEMENT-BLack-background1.png",123.0,123,"Kaunas","club",u));
            placeRepository.save(new Place("Jampub","","",123.0,123,"Kaunas","pub",u));
            placeRepository.save(new Place("Vilnus pub","","",123.0,123,"Vilnus","pub",u));
            Place place1 = new Place("test1","","https://scontent.fvno3-1.fna.fbcdn.net/v/t1.0-9/14063896_10201914928712972_71179004568042813_n.jpg?_nc_cat=0&oh=6c60348611f95a3a2ac45b862009983e&oe=5BBEB9F5",123.0,123,"test city","bar",testUser);
            Place place2 = new Place("test2","","https://scontent.fvno3-1.fna.fbcdn.net/v/t1.0-9/14063896_10201914928712972_71179004568042813_n.jpg?_nc_cat=0&oh=6c60348611f95a3a2ac45b862009983e&oe=5BBEB9F5",123.0,123,"test city","bar",testUser);
            Place place3 = new Place("test3","","https://scontent.fvno3-1.fna.fbcdn.net/v/t1.0-9/14063896_10201914928712972_71179004568042813_n.jpg?_nc_cat=0&oh=6c60348611f95a3a2ac45b862009983e&oe=5BBEB9F5",123.0,123,"test city","pub",testUser);
            place1.setApproved(true);
            place2.setApproved(true);
            place3.setApproved(true);
            bo.setApproved(true);
            bo2.setApproved(true);
            placeRepository.save(bo);
            placeRepository.save(bo2);
            placeRepository.save(place1);
            placeRepository.save(place2);
            placeRepository.save(place3);
            ratingRepository.save(new Rating(u,place1,5));
            ratingRepository.save(new Rating(u2,place1,3));
            Place commentPlace = new Place("comment place","","",123.0,123,"test city","pub",testUser);
            commentPlace.setApproved(true);
            placeRepository.save(commentPlace);
            commentRepository.save(new Comment("this place sucks", u, commentPlace));
            commentRepository.save(new Comment("this place is great", u, commentPlace));
            commentRepository.save(new Comment("really hot waitress", u, commentPlace));
            Place commentServicePlace = new Place("comment service","","",123.0,123,"test city","pub",testUser);
            placeRepository.save(commentServicePlace);
            userService.save(new User("User","123","User.rac@gmail.com","mihajlo","racic"));
        }
    }
}

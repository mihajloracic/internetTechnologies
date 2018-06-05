package mihajlo.exampleantony.it.service;

import mihajlo.exampleantony.it.entity.*;
import mihajlo.exampleantony.it.repository.*;
import mihajlo.exampleantony.it.service.voting.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;

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

    @Autowired
    PollService pollService;

    @Autowired
    PollRepository pollRepository;

    @Transactional
    public void populateData()  {
        commentRepository.deleteAll();
        pollRepository.deleteAll();
        ratingRepository.deleteAll();
        placeRepository.deleteAll();
        userRepositoryForTest.deleteAll();
        if(userRepositoryForTest.findByUsername("m1").size() == 0){
            User u = userRepositoryForTest.save( new User("m1","123","m1.rac@gmail.com","mihajlo","racic",""));
            User u2 = userRepositoryForTest.save( new User("Mihajlo","$2a$10$4UQxFJ0Txc3JJAlq6i7hgeRNQN5OoSpTt5NMKHKbPpeXdjWJDd4IO","m2.rac@gmail.com","mihajlo","racic","https://scontent.fvno3-1.fna.fbcdn.net/v/t1.0-1/p160x160/14063896_10201914928712972_71179004568042813_n.jpg?_nc_cat=0&oh=38e37aa55f2f48d058e21edc69d34f43&oe=5BB210B4"));
			User u3 = userRepositoryForTest.save( new User("Antony","$2a$10$4UQxFJ0Txc3JJAlq6i7hgeRNQN5OoSpTt5NMKHKbPpeXdjWJDd4IO","m3.rac@gmail.com","Antony","Cabero","https://scontent.fvno3-1.fna.fbcdn.net/v/t1.0-1/p160x160/32416529_10209612180296421_7322381956451139584_n.jpg?_nc_cat=0&oh=fdaef23d6e809dc2302f5bb432bd01e2&oe=5B861829"));
			User u4 = userRepositoryForTest.save( new User("Tomas","$2a$10$4UQxFJ0Txc3JJAlq6i7hgeRNQN5OoSpTt5NMKHKbPpeXdjWJDd4IO","m4.rac@gmail.com","Tomas","Ratru","https://scontent.fvno3-1.fna.fbcdn.net/v/t1.0-1/c0.1.160.160/p160x160/32264435_995036600662761_6341740115596935168_n.jpg?_nc_cat=0&oh=0e8d9a0499bacfa1f624577dae11053c&oe=5B7F081C"));
			User u5 = userRepositoryForTest.save( new User("Cindy","$2a$10$4UQxFJ0Txc3JJAlq6i7hgeRNQN5OoSpTt5NMKHKbPpeXdjWJDd4IO","m5.rac@gmail.com","Cindy","Jouiller","https://scontent.fvno3-1.fna.fbcdn.net/v/t1.0-1/p160x160/19989579_102765900381788_9106960291791042257_n.jpg?_nc_cat=0&oh=3b5d409e3ce60d1afe2c37b0ac673266&oe=5BC29809"));
			User u6 = userRepositoryForTest.save( new User("Nico","$2a$10$4UQxFJ0Txc3JJAlq6i7hgeRNQN5OoSpTt5NMKHKbPpeXdjWJDd4IO","m6.rac@gmail.com","Nico","Bertrand","https://scontent.fvno3-1.fna.fbcdn.net/v/t1.0-1/p160x160/32286514_10155328362996817_6486448567505387520_n.jpg?_nc_cat=0&oh=e2ce1987bef0aab1f676b1f1d36e8dff&oe=5B851A98"));
			User u7 = userRepositoryForTest.save( new User("Flo","$2a$10$4UQxFJ0Txc3JJAlq6i7hgeRNQN5OoSpTt5NMKHKbPpeXdjWJDd4IO","m7.rac@gmail.com","Flo","Xavier","https://scontent.fvno3-1.fna.fbcdn.net/v/t1.0-1/p160x160/13511983_713811992090447_9025787682658878275_n.jpg?_nc_cat=0&oh=3eedc4eb85cd966a0d85db1eaa1d896a&oe=5BBBDDFA"));
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
            Place place1 = new Place("Dzem'pub","orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scsed in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.","https://naktiniaiklubai.lt/sites/naktiniaiklubai.lt/files/styles/place_gallery_colorbox/public/2015/10/15/dzem_pub_kaunas_pabas_naktiniaiklubai.lt_5.jpg?itok=XLwJg_27",123.0,123,"Kaunas","pub",u6);
            Place place2 = new Place("Mojo","orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scsed in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.","http://renginiai.kasvyksta.lt/uploads/places/296/mojo-lounge-klubas-kaunas-16.jpg",123.0,123,"Kaunas","club/lounge",u4);
            Place place3 = new Place("Deja Vu","orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scsed in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.","https://naktiniaiklubai.lt/sites/naktiniaiklubai.lt/files/styles/place_gallery_colorbox/public/2015/10/16/dejavu_party_bar_naktinis_klubas_kaunas_naktiniaiklubai.lt_2.jpg?itok=Z2oJQmAm",123.0,123,"Kaunas","club",u2);
			Place place4 = new Place("Peleda","orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scsed in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.","https://scontent.fvno3-1.fna.fbcdn.net/v/t31.0-8/27912584_2418051274875248_4238812510760715030_o.jpg?_nc_cat=0&oh=9337dd08ee716f56a9565ddc13798b24&oe=5B7E4F15", 123.0,123,"Vilnius","Club",u7);
			Place place5 = new Place("Opium","orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scsed in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.","https://naktiniaiklubai.lt/sites/naktiniaiklubai.lt/files/styles/place_gallery_colorbox/public/2015/10/23/12047050_10153070429536472_5716152902254123395_n.jpg?itok=DUT97eJa",123.0,123,"Vilnius","Club",u3);
			Place place6 = new Place("Republic","orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scsed in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.","http://renginiai.kasvyksta.lt/uploads/places/231/republic-baras-kaunas-9.jpg",123.0,123,"Kaunas","bar",u3);
			Place place7 = new Place("Steakhouse Hazienda","orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scsed in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.","https://media-cdn.tripadvisor.com/media/photo-s/04/5a/ed/b0/hazienda.jpg",123.0,123,"Vilnius","Restaurant",u5);
			Place place8 = new Place("Black Bar","orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scsed in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.","https://igx.4sqi.net/img/general/600x600/58177035_zJRtEDR5J1HA8oSStuO7OPkhNgCmtajsD0-6YDGpXKE.jpg",123.0,123,"Siauliai","Pub",u4);
			Place place9 = new Place("Tabu","orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scsed in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.","http://retaildesignblog.net/wp-content/uploads/2015/02/Tabu-Restaurant-by-Ramunas-Manikas-Klaipeda-Lithuania.jpg",123.0,123,"Klaipeda","Restaurant",u6);
			Place place10 = new Place("Kapitol","orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scsed in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.","http://tic.siauliai.lt/wp-content/uploads/2015/05/DSC_0016.jpg",123.0,123,"Siauliai","Club",u5);
			
            place1.setApproved(true);
            place2.setApproved(true);
            place3.setApproved(true);
            place4.setApproved(true);
            place5.setApproved(true);
            place6.setApproved(true);
            place7.setApproved(true);
            place8.setApproved(true);
            place9.setApproved(true);			
			place10.setApproved(true);	
            bo.setApproved(true);
            bo2.setApproved(true);
			
            placeRepository.save(bo);
            placeRepository.save(bo2);
            placeRepository.save(place1);
            placeRepository.save(place2);
            placeRepository.save(place3);
            placeRepository.save(place4);
            placeRepository.save(place5);
            placeRepository.save(place6);
            placeRepository.save(place7);
            placeRepository.save(place8);
            placeRepository.save(place9);			
			placeRepository.save(place10);
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
            Poll poll = new Poll(new java.sql.Date(Calendar.getInstance().getTime().getTime()),u,"cool voting");
            poll.getUsers().add(u);
            poll.getPlaces().add(place1);
            pollRepository.save(poll);
            int asd = 2;
        }
    }
}

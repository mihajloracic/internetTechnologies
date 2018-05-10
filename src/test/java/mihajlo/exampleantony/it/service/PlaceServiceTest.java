package mihajlo.exampleantony.it.service;

import javassist.NotFoundException;
import mihajlo.exampleantony.it.entity.Place;
import mihajlo.exampleantony.it.entity.User;
import mihajlo.exampleantony.it.repository.PlaceRepository;
import mihajlo.exampleantony.it.repository.UserRepositoryForTest;
import mihajlo.exampleantony.it.service.place.AdminPlaceService;
import mihajlo.exampleantony.it.service.place.SuperAdminPlaceService;
import mihajlo.exampleantony.it.service.place.UserPlaceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlaceServiceTest {

    @Autowired
    MockDataService mockDataService;
    @Autowired
    PlaceRepository placeRepository;
    @Autowired
    UserRepositoryForTest userRepositoryForTest;
    @Autowired
    AdminPlaceService adminPlaceService;
    @Autowired
    SuperAdminPlaceService superAdminPlaceService;
    @Autowired
    UserPlaceService userPlaceService;

    @Test
    public void mockDataTest(){
            mockDataService.populateData();
            assert userRepositoryForTest.findByUsername("m2").size() != 0;
    }
    @Test
    public void repositoryInit(){
        assertThat(placeRepository).isNotNull();
        assertThat(userRepositoryForTest).isNotNull();
        assertThat(adminPlaceService).isNotNull();
        assertThat(superAdminPlaceService).isNotNull();
        assertThat(mockDataService).isNotNull();
    }

    @Test
    @Transactional
    public void getMyPlacesTest(){
        mockDataService.populateData();
        List<User> users =  userRepositoryForTest.findByUsername("m2");
        User user = userRepositoryForTest.findByUsername("m2").get(0);
        List<Place> places =adminPlaceService.getMyPlaces(user);
        assert places.size() == 1;
    }
    public void getMyPlacesTest2(){
        mockDataService.populateData();
        User user = userRepositoryForTest.findByUsername("m1").get(0);
        List<Place> places =adminPlaceService.getMyPlaces(user);
        assert places.size() == 4;
    }
    @Test
    public void savePlaceTest()  {
        mockDataService.populateData();
        User user = userRepositoryForTest.findByUsername("m3").get(0);
        Place p = null;
        try {
            p = adminPlaceService.save(new Place("New place from the test","","",123.0,123,"Kaunas","pub",user),user);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        ;
        assert placeRepository.findByName("New place from the test").size() == 1;
        try {
            adminPlaceService.save(p,user);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        assert placeRepository.findByName("New place from the test").size() == 1;
    }
    @Test
    public void savePlaceTestWrongUser(){

    }

    @Test
    public void getUnapprovedPlaces(){
        mockDataService.populateData();
        assert superAdminPlaceService.getUnapprovedPlaces().size() != 0;
    }

    @Test
    public void approvePlace(){
        mockDataService.populateData();
        User admin = userRepositoryForTest.findByUsername("superadmin").get(0);
        superAdminPlaceService.approvePlace(placeRepository.findByName("Bo").get(0),admin);
        assert  placeRepository.findByName("Bo").get(0).getApproved();
    }

    @Test
    public void userSearches1(){
        mockDataService.populateData();
        assert userPlaceService.getAllPlaces().size() != 0;

    }
    @Test
    public void userSearches2(){
        mockDataService.populateData();
        assert userPlaceService.getPlacesByCityAndType("test city", "bar").size() == 2;
    }
    @Test
    public void userSearches3(){
        mockDataService.populateData();
        assert userPlaceService.getPlacesInCity("test city").size() == 3;
    }

}

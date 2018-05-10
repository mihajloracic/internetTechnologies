package mihajlo.exampleantony.it.service;

import mihajlo.exampleantony.it.entity.Comment;
import mihajlo.exampleantony.it.entity.Place;
import mihajlo.exampleantony.it.entity.User;
import mihajlo.exampleantony.it.entity.dto.CommentDTO;
import mihajlo.exampleantony.it.repository.CommentRepository;
import mihajlo.exampleantony.it.repository.PlaceRepository;
import mihajlo.exampleantony.it.repository.UserRepositoryForTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceTest {
    @Autowired
    PlaceRepository placeRepository;
    @Autowired
    MockDataService mockDataService;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserRepositoryForTest userRepositoryForTest;
    @Autowired
    CommentService commentService;
    @Test
    public void addCommentTest(){
        mockDataService.populateData();
        Place place = placeRepository.findByName("comment service").get(0);
        User u = userRepositoryForTest.findByUsername("m3").get(0);
        commentService.addComment(new CommentDTO("super tekst", u.getId(),place.getId()),u);
        assert commentRepository.getCommentByPlace(place).size() == 1;
    }
    @Test
    public void fakeUserAddCommentTest(){
        mockDataService.populateData();
        mockDataService.populateData();
        Place place = placeRepository.findByName("comment service").get(0);
        User userWhoIsAddingCommen = userRepositoryForTest.findByUsername("m3").get(0);
        commentService.addComment(new CommentDTO("super tekst",new Long(32),place.getId()),userWhoIsAddingCommen);
        assert commentRepository.getCommentByPlace(place).size() == 1;
    }
    @Test
    @Transactional
    public void removeCommentTest(){
        mockDataService.populateData();
        Place place = placeRepository.findByName("test1").get(0);
        User adminUser = userRepositoryForTest.findByUsername("testUser").get(0);
        User userWhoIsAddingCommen = userRepositoryForTest.findByUsername("m3").get(0);
        Comment comment = commentService.addComment(new CommentDTO("super tekst",userWhoIsAddingCommen.getId(),place.getId()),userWhoIsAddingCommen);
        int sizeBefore = commentRepository.getCommentByPlace(place).size();
        commentService.removeComment(comment,adminUser);
        assert sizeBefore - 1 == commentRepository.getCommentByPlace(place).size();
    }

}

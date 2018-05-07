package mihajlo.exampleantony.it.repository;

import mihajlo.exampleantony.it.entity.Place;
import mihajlo.exampleantony.it.service.MockDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentRepositoryTest {
    @Autowired
    PlaceRepository placeRepository;
    @Autowired
    MockDataService mockDataService;
    @Autowired
    CommentRepository commentRepository;
    @Test
    public void getCommentsForPlace(){
        mockDataService.populateData();
        Place p = placeRepository.findByName("comment place").get(0);
        assert commentRepository.getCommentByPlace(p).size() == 3;
    }
}

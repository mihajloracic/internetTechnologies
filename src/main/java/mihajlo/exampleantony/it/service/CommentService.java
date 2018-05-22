package mihajlo.exampleantony.it.service;

import mihajlo.exampleantony.it.entity.Comment;
import mihajlo.exampleantony.it.entity.Place;
import mihajlo.exampleantony.it.entity.User;
import mihajlo.exampleantony.it.entity.dto.CommentDTO;
import mihajlo.exampleantony.it.repository.CommentRepository;
import mihajlo.exampleantony.it.repository.PlaceRepository;
import mihajlo.exampleantony.it.repository.UserRepositoryForTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentService {
    @Autowired
    UserRepositoryForTest userRepositoryForTest;
    @Autowired
    PlaceRepository placeRepository;
    @Autowired
    CommentRepository commentRepository;
    public Comment addComment(CommentDTO commentDTO,User user){
        if(commentDTO.userId != user.getId()){
            return null;
        }
        return commentRepository.save( new Comment(commentDTO.getText(),user,placeRepository.getOne(commentDTO.getPlacesId())));
    }
    public void removeComment(Comment comment,User user){
        Place place = placeRepository.getOne(comment.getPlace().getId());
        if(place.getUserCreated().getId() == user.getId()){
            commentRepository.delete(comment);
        }
    }

    public List<Comment> getCommentsForPlace(Long placeId){
        Place place = placeRepository.findOne(placeId);
        return commentRepository.getCommentByPlace(place);
    }
}

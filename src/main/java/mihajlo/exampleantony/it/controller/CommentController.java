package mihajlo.exampleantony.it.controller;

import mihajlo.exampleantony.it.entity.Comment;
import mihajlo.exampleantony.it.entity.CustomUserDetail;
import mihajlo.exampleantony.it.entity.User;
import mihajlo.exampleantony.it.entity.dto.CommentDTO;
import mihajlo.exampleantony.it.service.CommentService;
import mihajlo.exampleantony.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/comment",method = RequestMethod.GET)
    public List<Comment> getComments(@RequestParam("id") Long id){
        return commentService.getCommentsForPlace(id);
    }

    @RequestMapping(value="/comment",method = RequestMethod.POST)
    public Comment addComment(@RequestBody CommentDTO commentDTO){
        CustomUserDetail userDetail = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.getUser(userDetail);
        Comment comment = commentService.addComment(commentDTO,user);
        return comment;
    }
}

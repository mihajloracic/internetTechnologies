package mihajlo.exampleantony.it.controller;

import mihajlo.exampleantony.it.entity.Comment;
import mihajlo.exampleantony.it.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @RequestMapping(value = "/comment",method = RequestMethod.GET)
    public List<Comment> getComments(@RequestParam("id") Long id){
        return commentService.getCommentsForPlace(id);
    }
}

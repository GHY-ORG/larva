package cn.ghy.larva.controller;

import cn.ghy.larva.domain.Post;
import cn.ghy.larva.domain.PostMeta;
import cn.ghy.larva.service.IPostService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/admin/post")
@RestController
public class IPostController {

    private final IPostService iPostService;

    @Autowired
    public IPostController(IPostService iPostService) {
        this.iPostService = iPostService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> insert(@RequestBody Post post) {
        ResponseEntity<?> response;
        try {
            iPostService.insert(post);
            response = new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        ResponseEntity<?> response;
        try {
            Post post = iPostService.selectById(id);
            if (post != null) {
                iPostService.deleteById(id);
                response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> selectById(@PathVariable long id) {
        ResponseEntity<?> response;
        Post post = iPostService.selectById(id);
        if (post != null) {
            response = new ResponseEntity<>(post, HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> selectAll() {
        ResponseEntity<?> response;
        List<Post> postList = iPostService.selectAll();
        if (postList.size() > 0) {
            response = new ResponseEntity<>(postList, HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }
}

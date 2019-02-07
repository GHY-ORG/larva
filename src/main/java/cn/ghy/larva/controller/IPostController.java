package cn.ghy.larva.controller;

import cn.ghy.larva.domain.Category;
import cn.ghy.larva.domain.Post;
import cn.ghy.larva.service.IPostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "文章管理")
@RequestMapping(value = "/admin")
@RestController
public class IPostController {

    private final IPostService iPostService;

    @Autowired
    public IPostController(IPostService iPostService) {
        this.iPostService = iPostService;
    }

    @ApiOperation(value = "添加文章")
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public ResponseEntity<?> insertPost(@RequestBody Post post) {
        ResponseEntity<?> response;
        try {
            iPostService.insertPost(post);
            response = new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @ApiOperation(value = "删除文章")
    @RequestMapping(value = "/post/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePostById(@PathVariable long id) {
        ResponseEntity<?> response;
        try {
            Post post = iPostService.selectPostById(id);
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

    @ApiOperation(value = "根据Id查询文章")
    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> selectPostById(@PathVariable long id) {
        ResponseEntity<?> response;
        Post post = iPostService.selectPostById(id);
        if (post != null) {
            response = new ResponseEntity<>(post, HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @ApiOperation(value = "查询符合条件的所有文章")
    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public ResponseEntity<?> selectAllPost() {
        ResponseEntity<?> response;
        List<Post> postList = iPostService.selectAllPost();
        if (postList.size() > 0) {
            response = new ResponseEntity<>(postList, HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @ApiOperation(value = "添加分类")
    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public ResponseEntity<?> insertCategory(@RequestBody Category category) {
        ResponseEntity<?> response;
        try {
            iPostService.insertCategory(category);
            response = new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}

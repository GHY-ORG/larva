package cn.ghy.larva.controller;

import cn.ghy.larva.domain.Post;
import cn.ghy.larva.domain.PostMeta;
import cn.ghy.larva.domain.Response;
import cn.ghy.larva.service.IPostService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Response insert(@RequestBody @Valid Post post, BindingResult result) {
        Response response;
        if (result.hasErrors()) {
            response = new Response(400, result.toString());
        } else {
            try {
                iPostService.postInsert(post);
                Long postId = post.getPostId();
                for (PostMeta meta : post.getMetas()) {
                    meta.setPostId(postId);
                    iPostService.metaInsert(meta);
                }
                response = new Response(200);
                System.out.println();
            } catch (Exception e) {
                response = new Response(400);
            }
        }
        return response;
    }

    @RequestMapping(value = "/{postId}", method = RequestMethod.DELETE)
    public Response deleteById(@PathVariable long postId) {
        Response response;
        try {
            Post post = iPostService.selectById(postId);
            if (post != null) {
                iPostService.deleteById(postId);
                response = new Response(204);
            } else {
                response = new Response(400);
            }
        } catch (Exception e) {
            response = new Response(400);
        }
        return response;
    }

    @RequestMapping(value = "/{postId}", method = RequestMethod.GET)
    public Response selectById(@PathVariable long postId) {
        Response response;
        Post post = iPostService.selectById(postId);
        if (post != null) {
            response = new Response(200, post);
        } else {
            response = new Response(404);
        }
        return response;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Response selectAll(@RequestParam(value = "page", defaultValue = "1") int page,
                              @RequestParam(value = "per_page", defaultValue = "20") int perPage) {
        Response response;
        PageHelper.startPage(page, perPage);
        List<Post> postList = iPostService.selectAll();
        if (postList.size() > 0) {
            PageInfo<Post> pageInfo = new PageInfo<>(postList);
            response = new Response(200, pageInfo);
        } else {
            response = new Response(404);
        }
        return response;
    }
}

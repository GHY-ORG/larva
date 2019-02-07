package cn.ghy.larva.controller;

import cn.ghy.larva.domain.File;
import cn.ghy.larva.domain.Post;
import cn.ghy.larva.service.IFileService;
import cn.ghy.larva.service.IPostService;
import cn.ghy.larva.util.FileUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping(value = "/gallery")
public class GalleryController {

    private final IPostService iPostService;
    private final IFileService IFileService;
    private FileUtil fileUtil = new FileUtil();

    @Autowired
    public GalleryController(IPostService iPostService, IFileService IFileService) {
        this.iPostService = iPostService;
        this.IFileService = IFileService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> upload(HttpServletRequest request) {
        String title = request.getParameter("title");
        String desc = request.getParameter("desc");
        try {
            ArrayList<File> files = fileUtil.upload(request, "gallery", desc);
            for (File file : files) {
                long userId = 1;
                Date now = new Date();

                file.setUserId(userId);
                IFileService.insert(file);

                Post post = new Post();
                post.setUserId(userId);
                post.setPostType(2);
                post.setPostTitle(title);
                post.setPostContent(desc);
                post.setCreateTime(now);
                post.setModifiedTime(now);
                iPostService.insertPost(post);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

package cn.ghy.larva.controller;

import cn.ghy.larva.domain.Comment;
import cn.ghy.larva.service.CommentService;
import cn.ghy.larva.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Comment controller
 *
 * @author xyao
 */
@Api(description = "评论管理") @RequestMapping("/comments") @RestController
public class CommentController {

    private final CommentService commentService;
    private final IUserService iUserService;

    @Autowired
    public CommentController(CommentService commentService, IUserService iUserService) {
        this.commentService = commentService;
        this.iUserService = iUserService;
    }

    @ApiOperation("新增评论") @PostMapping
    public ResponseEntity<?> addComment(@RequestBody Comment comment) {
        if (comment.getCommentId() == null) {
            try {
                iUserService.register(comment.getUser());
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        try {
            commentService.addComment(comment);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    //A comment id is better or a comment obj with only the id attr?
    @ApiOperation("删除评论")
    @ApiImplicitParam(value = "评论ID", name = "comment-id", example = "10000", required = true)
    @DeleteMapping public ResponseEntity<?> deleteComment(
        @RequestParam("comment-id") long commentId) {
        try {
            commentService.deleteComment(commentId);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation("更新评论") @ApiImplicitParam(value = "评论", name = "comment", required = true)
    @PatchMapping public ResponseEntity<?> updateComment(@RequestBody Comment comment) {
        try {
            commentService.updateComment(comment);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @ApiOperation("根据文章ID获取顶级评论数量")
    @ApiImplicitParam(value = "文章ID", name = "post-id", required = true)
    @GetMapping("/{postId}/num") public ResponseEntity<?> getCommentNum(@PathVariable long postId) {
        return new ResponseEntity<>(commentService.getCommentNum(postId), HttpStatus.OK);
    }

    @ApiOperation("根据文章ID获取评论列表")
    @ApiImplicitParams({@ApiImplicitParam(value = "文章ID", name = "post-id", required = true),
        @ApiImplicitParam(value = "已加载的评论数量", name = "num-loaded", defaultValue = "0"),
        @ApiImplicitParam(value = "本次请求最大加载数量", name = "max-num", defaultValue = "正无穷"),
        @ApiImplicitParam(value = "每条评论子评论最大数量", name = "reply-max-num", defaultValue = "3")})
    @GetMapping("/{postId}") public ResponseEntity<?> getCommentList(@PathVariable long postId,
        @RequestParam(value = "num-loaded", defaultValue = "0") int numLoaded,
        @RequestParam(value = "max-num", defaultValue = "2147483647") int maxNum,
        @RequestParam(value = "reply-max-num", defaultValue = "3") int replyMaxNum) {
        List<Comment> commentList =
            commentService.getCommentList(postId, numLoaded, maxNum, replyMaxNum);
        return new ResponseEntity<>(commentList, HttpStatus.OK);
    }

    @ApiOperation("获取评论（目前只支持顶级评论）的回复数量")
    @ApiImplicitParams({@ApiImplicitParam(value = "父评论ID", name = "comment-id", required = true),
        @ApiImplicitParam(value = "后代模式", name = "descendant-mode", defaultValue = "true")})
    @GetMapping("/num")
    public ResponseEntity<?> getReplyNum(@RequestParam("comment-id") long commentId,
        @RequestParam(value = "descendant-mode", defaultValue = "true") boolean descendantMode) {
        return new ResponseEntity<>(commentService.getReplyNum(commentId), HttpStatus.OK);
    }

    @ApiOperation("获取某一评论的回复列表")
    @ApiImplicitParams({@ApiImplicitParam(value = "评论ID", name = "comment-id", required = true),
        @ApiImplicitParam(value = "已加载的子评论数量", name = "reply-num-loaded", required = true),
        @ApiImplicitParam(value = "最大加载数量", name = "max-num", defaultValue = "正无穷")})
    @GetMapping("")
    public ResponseEntity<?> getMoreReplies(@RequestParam("comment-id") long commentId,
        @RequestParam("reply-num-loaded") int replyNumLoaded,
        @RequestParam(value = "max-num", defaultValue = "2147483647") int maxNum) {
        List<Comment> replyList = commentService.getReplyList(commentId, replyNumLoaded, maxNum);
        return new ResponseEntity<>(replyList, HttpStatus.OK);
    }
}

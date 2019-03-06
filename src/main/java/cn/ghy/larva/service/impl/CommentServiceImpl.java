package cn.ghy.larva.service.impl;

import cn.ghy.larva.dao.CommentMapper;
import cn.ghy.larva.domain.Comment;
import cn.ghy.larva.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author xyao
 */
@Service public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;

    @Autowired public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override public long addComment(Comment comment) throws Exception {
        commentMapper.insertComment(comment);
        return comment.getCommentId();
    }

    @Override public void deleteComment(long commentId) {
        commentMapper.disableComment(commentId);
    }

    @Override public void updateComment(Comment comment) {
        comment.setTimeModified(new Date());
        commentMapper.updateComment(comment);
    }

    @Override public Comment getComment(long commentId, int maxNum) {
        return commentMapper.selectComment(commentId, maxNum);
    }

    @Override public int getCommentNum(long postId) {
        return commentMapper.selectTopLevelCommentNum(postId);
    }

    @Override
    public List<Comment> getCommentList(long postId, int numLoaded, int maxNum, int subMaxNum) {
        List<Comment> comments = commentMapper.selectTopLevelCommentList(postId, numLoaded, maxNum);
        for (Comment c : comments) {
            c.setReplyList(getReplyList(c.getCommentId(), 0, subMaxNum));
        }
        return comments;
    }

    @Override public int getReplyNum(long commentId) {
        return commentMapper.selectDescendantCommentNum(commentId);
    }

    @Override public List<Comment> getReplyList(long commentId, int numLoaded, int maxNum) {
        return commentMapper.selectDescendantCommentList(commentId, numLoaded, maxNum);
    }

}

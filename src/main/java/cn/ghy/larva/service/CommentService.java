package cn.ghy.larva.service;

import cn.ghy.larva.domain.Comment;

import java.util.List;

/**
 * Comment service
 *
 * @author xyao
 */
public interface CommentService {

    /**
     * @param comment the comment
     * @return the key
     */
    long addComment(Comment comment) throws Exception;

    /**
     * @param commentId id of the comment
     * @return successful
     */
    void deleteComment(long commentId) throws Exception;

    /**
     * @param comment the modified comment
     * @return successful
     */
    void updateComment(Comment comment) throws Exception;

    /**
     * @param commentId ID
     * @param maxNum    the max num of the descendant
     * @return comment filling of descendant comments with a max num of @{maxNum}
     */
    Comment getComment(long commentId, int maxNum);

    /**
     * @param postId post ID
     * @return num of top-level comments
     */
    int getCommentNum(long postId);

    /**
     * @param postId    ID of the post
     * @param numLoaded nums of the comments already loaded
     * @param maxNum    max value of the comment num returned by this query
     * @param subMaxNum max num of the sub-comment (replies)
     * @return the comment list
     */
    List<Comment> getCommentList(long postId, int numLoaded, int maxNum, int subMaxNum);

    /**
     * @param commentId parent ID
     * @return num of descendant
     */
    int getReplyNum(long commentId);

    /**
     * @param commentId ID of the comment (only for the supreme comment
     * @param numLoaded the num of the replies already loaded
     * @param maxNum    the max num of the replies this time
     * @return descendant comments of comment which @{commentId} referred
     */
    List<Comment> getReplyList(long commentId, int numLoaded, int maxNum);
}

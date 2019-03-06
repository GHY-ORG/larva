package cn.ghy.larva.dao;

import cn.ghy.larva.domain.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * comment DAO (implemented by MyBatis)
 *
 * @author xyao
 */
public interface CommentMapper {

    /**
     * @param commentId the comment ID
     * @param rows      the max rows
     * @return the comment with the max of @{rows} descendant comment list
     */
    Comment selectComment(@Param("commentId") long commentId, @Param("rows") int rows);

    /**
     * @param postId post ID
     * @param offset the offset
     * @param rows   the max rows
     * @return comment list
     */
    List<Comment> selectTopLevelCommentList(@Param("postId") long postId,
        @Param("offset") int offset, @Param("rows") int rows);

    /**
     * @param postId post ID
     * @return the num of the top-level comment
     */
    int selectTopLevelCommentNum(long postId);

    /**
     * get descendant comments
     *
     * @param commentId comment ID
     * @param offset    the offset
     * @param rows      the max rows
     * @return descendant comments with a max of @{rows} having an offset of @{offset}
     */
    List<Comment> selectDescendantCommentList(@Param("commentId") long commentId,
        @Param("offset") int offset, @Param("rows") int rows);

    /**
     * @param commentId parent ID
     * @return num of the descendant
     */
    int selectDescendantCommentNum(long commentId);

    /**
     * @param comment the comment
     * @return rows effected
     */
    int insertComment(Comment comment);

    int updateComment(Comment currentComment);

    int disableComment(long commentId);
}

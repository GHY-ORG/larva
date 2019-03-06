package cn.ghy.larva.domain;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

/**
 * Comment domain model
 *
 * @author xyao
 */
public class Comment {

    /**
     * ID
     */
    private Long commentId;

    /**
     * comment content
     */
    private String content;

    /**
     * commentator
     */
    private User user;

    /**
     * ID of the post
     */
    private Long postId;

    /**
     * descendant comments
     */
    private List<Comment> replyList;

    /**
     * comment replied (parent node)
     */
    private Comment commentReplied;

    /**
     * time created
     */
    private Date timeCreated;

    /**
     * time modified
     */
    private Date timeModified;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public List<Comment> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Comment> replyList) {
        this.replyList = replyList;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Date getTimeModified() {
        return timeModified;
    }

    public void setTimeModified(Date timeModified) {
        this.timeModified = timeModified;
    }

    public Comment getCommentReplied() {
        return commentReplied;
    }

    public void setCommentReplied(Comment commentReplied) {
        this.commentReplied = commentReplied;
    }

    /**
     * for test
     *
     * @return JSON
     */
    @Override public String toString() {
        Field[] declaredFields = getClass().getDeclaredFields();
        StringBuilder stringBuilder = new StringBuilder();
        for (Field f : declaredFields) {
            String name = f.getName();
            try {
                Object o = f.get(this);
                if (o != null) {
                    stringBuilder.append(",\n\"" + name + "\":").append(o);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return "{\n" + stringBuilder.substring(2) + "\n}";
    }
}

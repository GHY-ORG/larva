package cn.ghy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * @author Ziyang
 * @Email meetziyang@gmail.com
 * @description 文件 前端控制器
 * @since 2018/10/2 17:54
 */
public class File implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文件Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 文件名
     */
    private String name;

    /**
     * 文件后缀
     */
    private String suffix;

    /**
     * 文件大小，单位bit
     */
    private Long size;

    /**
     * 本地路径
     */
    private String localUrl;

    /**
     * 客户端访问路径
     */
    private String visitUrl;

    /**
     * 文件描述
     */
    private String description;

    /**
     * 上传用户Id
     */
    private Integer uploadUid;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是否逻辑删除
     */
    private Integer isDeleted;

    /**
     * 是否客户端可见
     */
    private Integer isVisible;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
    public String getLocalUrl() {
        return localUrl;
    }

    public void setLocalUrl(String localUrl) {
        this.localUrl = localUrl;
    }
    public String getVisitUrl() {
        return visitUrl;
    }

    public void setVisitUrl(String visitUrl) {
        this.visitUrl = visitUrl;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getUploadUid() {
        return uploadUid;
    }

    public void setUploadUid(Integer uploadUid) {
        this.uploadUid = uploadUid;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
    public Integer getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(Integer isVisible) {
        this.isVisible = isVisible;
    }

    @Override
    public String toString() {
        return "File{" +
        "id=" + id +
        ", name=" + name +
        ", suffix=" + suffix +
        ", size=" + size +
        ", localUrl=" + localUrl +
        ", visitUrl=" + visitUrl +
        ", description=" + description +
        ", uploadUid=" + uploadUid +
        ", createTime=" + createTime +
        ", isDeleted=" + isDeleted +
        ", isVisible=" + isVisible +
        "}";
    }
}

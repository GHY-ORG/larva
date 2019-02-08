package cn.ghy.larva.controller;

import cn.ghy.larva.domain.Category;
import cn.ghy.larva.domain.Post;
import cn.ghy.larva.domain.Tag;
import cn.ghy.larva.service.IPostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ziyang
 */
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
  public ResponseEntity<?> deletePostByPostId(@PathVariable Long id) {
    ResponseEntity<?> response;
    try {
      iPostService.deletePostByPostId(id);
      response = new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return response;
  }

  @ApiOperation(value = "修改文章")
  @RequestMapping(value = "/post", method = RequestMethod.PUT)
  public ResponseEntity<?> updatePostByPostId(@RequestBody Post post) {
    ResponseEntity<?> response;
    try {
      iPostService.updatePostByPostId(post);
      response = new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return response;
  }

  @ApiOperation(value = "根据Id查询文章")
  @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
  public ResponseEntity<?> selectPostByPostId(@PathVariable Long id) {
    Post post = iPostService.selectPostByPostId(id);
    return post != null ? new ResponseEntity<>(post, HttpStatus.OK)
        : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @ApiOperation(value = "查询符合条件的所有文章")
  @RequestMapping(value = "/post", method = RequestMethod.GET)
  public ResponseEntity<?> selectAllPost(
      @RequestParam(value = "user_id", defaultValue = "") Long userId,
      @RequestParam(value = "post_title", defaultValue = "") String postTitle,
      @RequestParam(value = "post_content", defaultValue = "") String postContent,
      @RequestParam(value = "post_type", defaultValue = "") Integer postType,
      @RequestParam(value = "post_status", defaultValue = "") Integer postStatus,
      @RequestParam(value = "category_id", defaultValue = "") Long categoryId,
      @RequestParam(value = "tag_id", defaultValue = "") Long tagId) {
    List<Post> posts =
        iPostService.selectAllPost(userId, postTitle, postContent, postType, postStatus, categoryId,
            tagId);
    return posts.size() > 0 ? new ResponseEntity<>(posts, HttpStatus.OK)
        : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @ApiOperation(value = "添加分类")
  @RequestMapping(value = "/category", method = RequestMethod.POST)
  public ResponseEntity<?> insertCategory(@RequestBody Category category) {
    ResponseEntity<?> response;
    try {
      iPostService.insertCategory(category);
      response = new ResponseEntity<>(HttpStatus.CREATED);
    } catch (Exception e) {
      response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return response;
  }

  @ApiOperation(value = "删除分类")
  @RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<?> deleteCategoryByCategoryId(@PathVariable Long id) {
    ResponseEntity<?> response;
    try {
      iPostService.deleteCategoryByCategoryId(id);
      response = new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return response;
  }

  @ApiOperation(value = "修改分类")
  @RequestMapping(value = "/category", method = RequestMethod.PUT)
  public ResponseEntity<?> updateCategoryByCategoryId(@RequestBody Category category) {
    ResponseEntity<?> response;
    try {
      iPostService.updateCategoryByCategoryId(category);
      response = new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return response;
  }

  @ApiOperation(value = "根据Id查询分类")
  @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
  public ResponseEntity<?> selectCategoryByCategoryId(@PathVariable Long id) {
    Category category = iPostService.selectCategoryByCategoryId(id);
    return category != null ? new ResponseEntity<>(category, HttpStatus.OK)
        : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @ApiOperation(value = "查询符合条件的所有分类")
  @RequestMapping(value = "/category", method = RequestMethod.GET)
  public ResponseEntity<?> selectAllCategory(
      @RequestParam(value = "category_name", defaultValue = "") String categoryName) {
    List<Category> categories = iPostService.selectAllCategory(categoryName);
    return categories.size() > 0 ? new ResponseEntity<>(categories, HttpStatus.OK)
        : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @ApiOperation(value = "添加标签")
  @RequestMapping(value = "/tag", method = RequestMethod.POST)
  public ResponseEntity<?> insertTag(@RequestBody Tag tag) {
    ResponseEntity<?> response;
    try {
      iPostService.insertTag(tag);
      response = new ResponseEntity<>(HttpStatus.CREATED);
    } catch (Exception e) {
      response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return response;
  }

  @ApiOperation(value = "删除标签")
  @RequestMapping(value = "/tag/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<?> deleteTagByTagId(@PathVariable Long id) {
    ResponseEntity<?> response;
    try {
      iPostService.deleteTagByTagId(id);
      response = new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return response;
  }

  @ApiOperation(value = "更新标签")
  @RequestMapping(value = "/tag", method = RequestMethod.PUT)
  public ResponseEntity<?> updateTagByTagId(@RequestBody Tag tag) {
    ResponseEntity<?> response;
    try {
      iPostService.updateTagByTagId(tag);
      response = new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return response;
  }

  @ApiOperation(value = "根据Id查询标签")
  @RequestMapping(value = "/tag/{id}", method = RequestMethod.GET)
  public ResponseEntity<?> selectTagByTagId(@PathVariable Long id) {
    Tag tag = iPostService.selectTagByTagId(id);
    return tag != null ? new ResponseEntity<>(tag, HttpStatus.OK)
        : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @ApiOperation(value = "查询符合条件的所有标签")
  @RequestMapping(value = "/tag", method = RequestMethod.GET)
  public ResponseEntity<?> selectAllTag(
      @RequestParam(value = "tag_name", defaultValue = "") String tagName) {
    List<Tag> tags = iPostService.selectAllTag(tagName);
    return tags.size() > 0 ? new ResponseEntity<>(tags, HttpStatus.OK)
        : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}

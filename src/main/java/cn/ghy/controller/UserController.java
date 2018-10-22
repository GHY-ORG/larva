package cn.ghy.controller;


import cn.ghy.entity.Response;
import cn.ghy.entity.User;
import cn.ghy.service.UserService;
import cn.ghy.utils.PageUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ziyang
 * @Email meetziyang@gmail.com
 * @description 用户 前端控制器
 * @since 2018/10/2 17:54
 */
@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(value = "/{uid}", method = RequestMethod.GET)
  public Response selectById(@PathVariable int uid) {
    Response response;
    User user = userService.getById(uid);
    if (user != null) {
      response = new Response(200, "Successful.", user);
    } else {
      response = new Response(404, "The user not found.");
    }
    return response;
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public Response selectAll(@RequestParam(value = "page", defaultValue = "1") int page,
      @RequestParam(value = "per_page", defaultValue = "20") int perPage,
      @RequestParam(value = "user_name", defaultValue = "") String userName,
      @RequestParam(value = "real_name", defaultValue = "") String realName,
      @RequestParam(value = "email", defaultValue = "") String email,
      @RequestParam(value = "sortby", defaultValue = "uid") String column,
      @RequestParam(value = "order", defaultValue = "asc") String order) {
    Response response;
    IPage<User> userIPage = userService.page(new Page<>(page, perPage),
        new QueryWrapper<User>().like("user_name", userName).like("real_name", realName)
            .like("email", email).orderBy(true, new PageUtils().isAsc(order), column));
    if (userIPage.getSize() > 0) {
      response = new Response(200, "Successful.", userIPage);
    } else {
      response = new Response(404, "User not found.");
    }
    return response;
  }

  @RequestMapping(value = "", method = RequestMethod.PUT)
  public Response updateById(@RequestBody @Valid User user, BindingResult result) {
    Response response;
    if (result.hasErrors()) {
      response = new Response(400, "Illegal input.", result.toString());
    } else {
      try {
        if (userService.getById(user.getUid()) != null) {
          userService.updateById(user);
          response = new Response(201, "The user has been successfully updated.");
        } else {
          response = new Response(400, "The user does not exist and cannot be updated.");
        }
      } catch (Exception e) {
        response = new Response(400, "Failed to update the user.");
      }
    }
    return response;
  }

  @RequestMapping(value = "/{uid}/enable", method = RequestMethod.PUT)
  public Response enableById(@PathVariable int uid) {
    Response response;
    try {
      User user = userService.getById(uid);
      if (user != null) {
        user.setIsEnabled(1);
        userService.updateById(user);
        response = new Response(201, "The user has been successfully enabled.");
      } else {
        response = new Response(400, "The user does not exist and cannot be enabled.");
      }
    } catch (Exception e) {
      response = new Response(400, "Failed to enable the user.");
    }
    return response;
  }

  @RequestMapping(value = "/{uid}", method = RequestMethod.DELETE)
  public Response deleteById(@PathVariable int uid) {
    Response response;
    try {
      User user = userService.getById(uid);
      if (user != null) {
        userService.removeById(user.getUid());
        response = new Response(204, "The user has been successfully deleted.");
      } else {
        response = new Response(400, "The user does not exist and cannot be deleted.");
      }
    } catch (Exception e) {
      response = new Response(400, "Failed to delete the user.");
    }
    return response;
  }
}
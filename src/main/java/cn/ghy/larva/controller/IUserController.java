package cn.ghy.larva.controller;

import cn.ghy.larva.domain.User;
import cn.ghy.larva.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/admin")
@Api(description = "用户管理")
public class IUserController {
    private final IUserService iUserService;

    @Autowired
    public IUserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @ApiOperation(value = "用户登录")
    @ApiImplicitParams({@ApiImplicitParam(value = "用户名", name = "userName", example = "鲁迅", required = true), @ApiImplicitParam(value = "用户密码", name = "password", example = "A1234567", required = true)})
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestParam String userName, @RequestParam String password) {
        return new ResponseEntity<>(iUserService.login(userName, password), HttpStatus.OK);
    }

    @ApiOperation(value = "用户注册", notes = "1，用户名长度大于等于2且小于等于50；\n 2，真实姓名长度大于等于2且小于等于15；\n 3，密码长度大于等于6且至少包含数字、字母、符号中的任意两种；\n 4，用户邮箱未注册。")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@Valid @RequestBody User user, BindingResult bindingResult) {
        ResponseEntity<?> response;
        if (bindingResult.hasErrors()) {
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            System.out.println(bindingResult.getAllErrors());
        } else {
            if (iUserService.isEmailAvailable(user.getUserEmail())) {
                iUserService.register(user);
                response = new ResponseEntity<>(HttpStatus.OK);
            } else {
                response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return response;
    }

    @ApiOperation(value = "邮箱检验", notes = "检验邮箱是否已被注册")
    @ApiImplicitParam(value = "email", name = "用户邮箱", required = true)
    @RequestMapping(value = "/register/is-email-available", method = RequestMethod.GET)
    public ResponseEntity<?> isEmailAvailable(@RequestParam String email) {
        return new ResponseEntity<>(iUserService.isEmailAvailable(email), HttpStatus.OK);
    }

    @ApiOperation(value = "根据Id查询用户")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> selectById(@PathVariable Long id) {
        return new ResponseEntity<>(iUserService.selectById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "查询符合条件的所有用户")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<?> selectAll() {
        return new ResponseEntity<>(iUserService.selectAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "更新/添加用户信息")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateById(@RequestBody User user) {
        return new ResponseEntity<>(iUserService.selectAll(), HttpStatus.OK);
    }
}

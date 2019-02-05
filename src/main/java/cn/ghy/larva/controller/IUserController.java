package cn.ghy.larva.controller;

import cn.ghy.larva.domain.User;
import cn.ghy.larva.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/admin")
public class IUserController {
    private final IUserService iUserService;

    @Autowired
    public IUserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody User user) {
        ResponseEntity<?> response;
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        try {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            iUserService.register(user);
            response = new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestParam String userName, @RequestParam String password) {
        return new ResponseEntity<>(iUserService.login(userName, password), HttpStatus.OK);
    }
}

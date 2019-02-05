package cn.ghy.larva.service;

import cn.ghy.larva.domain.User;

import java.util.List;

public interface IUserService {

    void register(User user);

    String login(String userName, String password);

    void deleteById(Long userId);

    User selectById(Long userId);

    User selectByUserName(String userName);

    List<User> selectAll();
}

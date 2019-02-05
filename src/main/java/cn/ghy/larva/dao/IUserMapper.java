package cn.ghy.larva.dao;

import cn.ghy.larva.domain.User;

import java.util.List;

public interface IUserMapper {
    Long userInsert(User user);

    Long isEmailAvailable(String userEmail);

    int deleteById(Long userId);

    int updateById(User user);

    User selectByUserName(String userName);

    User selectById(Long userId);

    List<User> selectAll();
}
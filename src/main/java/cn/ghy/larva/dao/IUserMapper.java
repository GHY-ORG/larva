package cn.ghy.larva.dao;

import cn.ghy.larva.domain.User;
import java.util.List;

/**
 * @author Ziyang
 */
public interface IUserMapper {
  /**
   * <p>
   * 插入用户信息（仅包含用户基本信息），用于用户的注册等。
   * </p>
   *
   * @param user 用户
   * @return userId 用户Id
   */
  Long userInsert(User user);

  /**
   * @param userEmail 用户注册邮箱
   */
  Long isEmailAvailable(String userEmail);

  int deleteById(Long userId);

  int updateById(User user);

  User selectByUserName(String userName);

  User selectById(Long userId);

  List<User> selectAll();
}
package cn.ghy.security;

import cn.ghy.entity.User;
import cn.ghy.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @Author: Ziyang
 * @Email: meetziyang@gmail.com
 * @Date: 2018/9/2 12:23
 * @Description:
 */
public class CustomUserDetailService implements UserDetailsService {

  @Autowired
  private UserService userService;

  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    UserDetails userDetails;
    cn.ghy.entity.User user = userService.getOne(new QueryWrapper<User>().eq("email", s));
    Collection<GrantedAuthority> authList = getAuthorities();
    userDetails = new org.springframework.security.core.userdetails.User(user.getEmail(),
        user.getPassword(), user.getIsEnabled() == 1, true, true, true,
        authList);
    return userDetails;
  }

  private Collection<GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> authList = new ArrayList<>();
    authList.add(new SimpleGrantedAuthority("ROLE_USER"));
    return authList;
  }
}

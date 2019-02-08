package cn.ghy.larva.common.security.service;

import cn.ghy.larva.domain.User;
import cn.ghy.larva.service.IUserService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Ziyang
 */
@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {
  private IUserService iUserService;

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    User user = iUserService.selectByUserName(userName);
    return new org.springframework.security.core.userdetails.User(userName, user.getPassword(),
        getAuthorities());
  }

  private Collection<GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> authList = new ArrayList<>();
    authList.add(new SimpleGrantedAuthority("ROLE_USER"));
    return authList;
  }
}

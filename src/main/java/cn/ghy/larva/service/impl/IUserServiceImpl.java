package cn.ghy.larva.service.impl;

import cn.ghy.larva.common.security.service.CustomUserDetailsServiceImpl;
import cn.ghy.larva.common.util.TokenUtil;
import cn.ghy.larva.dao.IUserMapper;
import cn.ghy.larva.domain.User;
import cn.ghy.larva.service.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Ziyang
 */
@Service
public class IUserServiceImpl implements IUserService {
  private final IUserMapper iUserMapper;
  private final TokenUtil tokenUtil;
  private final AuthenticationManager authenticationManager;
  private final CustomUserDetailsServiceImpl userDetailsService;

  @Autowired
  public IUserServiceImpl(IUserMapper iUserMapper, TokenUtil tokenUtil,
      AuthenticationManager authenticationManager,
      CustomUserDetailsServiceImpl userDetailsService) {
    this.iUserMapper = iUserMapper;
    this.tokenUtil = tokenUtil;
    this.authenticationManager = authenticationManager;
    this.userDetailsService = userDetailsService;
  }

  @Override public void register(User user) {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    iUserMapper.userInsert(user);
  }

  @Override public boolean isEmailAvailable(String userEmail) {
    return iUserMapper.isEmailAvailable(userEmail) == 0;
  }

  @Override public String login(String userName, String password) {
    UsernamePasswordAuthenticationToken upToken =
        new UsernamePasswordAuthenticationToken(userName, password);
    Authentication authentication = authenticationManager.authenticate(upToken);
    SecurityContextHolder.getContext().setAuthentication(authentication);
    UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
    return tokenUtil.generateToken(userDetails);
  }

  @Override public void deleteById(Long userId) {
    iUserMapper.deleteById(userId);
  }

  @Override public User selectById(Long userId) {
    return iUserMapper.selectById(userId);
  }

  @Override public User selectByUserName(String userName) {
    return iUserMapper.selectByUserName(userName);
  }

  @Override public List<User> selectAll() {
    return iUserMapper.selectAll();
  }
}

package cn.ghy.larva.service.impl;

import cn.ghy.larva.dao.IUserMapper;
import cn.ghy.larva.domain.User;
import cn.ghy.larva.security.CustomUserDetailsService;
import cn.ghy.larva.service.IUserService;
import cn.ghy.larva.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IUserServiceImpl implements IUserService {
    private final IUserMapper iUserMapper;
    private final TokenUtil tokenUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomUserDetailsService userDetailsService;

    public IUserServiceImpl(IUserMapper iUserMapper, TokenUtil tokenUtil) {
        this.iUserMapper = iUserMapper;
        this.tokenUtil = tokenUtil;
    }


    public void register(User user) {
        iUserMapper.userInsert(user);
    }

    public String login(String userName, String password) {
        try {
            UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(userName, password);
            Authentication authentication = authenticationManager.authenticate(upToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception e) {
            System.out.println(e);
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
        return tokenUtil.generateToken(userDetails);
    }

    public void deleteById(Long userId) {
        iUserMapper.deleteById(userId);
    }

    public User selectById(Long userId) {
        return iUserMapper.selectById(userId);
    }

    public User selectByUserName(String userName) {
        return iUserMapper.selectByUserName(userName);
    }

    public List<User> selectAll() {
        return iUserMapper.selectAll();
    }
}

package cn.ghy.larva.common.security;

import cn.ghy.larva.common.security.service.CustomUserDetailsServiceImpl;
import cn.ghy.larva.common.util.TokenUtil;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @author Ziyang
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  @Autowired
  private TokenUtil tokenUtil;

  @Autowired
  private CustomUserDetailsServiceImpl customUserDetailsServiceImpl;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain chain) throws ServletException, IOException {
    String authHeader = request.getHeader("Authorization");
    String tokenHead = "Bearer ";
    if (authHeader != null && authHeader.startsWith(tokenHead)) {
      String authToken = authHeader.substring(tokenHead.length());
      String username = tokenUtil.getUsernameFromToken(authToken);
      if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
        UserDetails userDetails = this.customUserDetailsServiceImpl.loadUserByUsername(username);
        if (tokenUtil.validateToken(authToken, userDetails)) {
          UsernamePasswordAuthenticationToken authentication =
              new UsernamePasswordAuthenticationToken(userDetails, null,
                  userDetails.getAuthorities());
          authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
          SecurityContextHolder.getContext().setAuthentication(authentication);
        }
      }
    }
    chain.doFilter(request, response);
  }
}

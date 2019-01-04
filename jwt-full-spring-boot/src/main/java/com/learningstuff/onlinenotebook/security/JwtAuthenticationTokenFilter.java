package com.learningstuff.onlinenotebook.security;


import com.learningstuff.onlinenotebook.sevice.CustomUserDetailsService;
import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final CustomUserDetailsService customUserDetailsService;
    private final JwtTokenUtil jwtTokenUtil;

    public JwtAuthenticationTokenFilter(CustomUserDetailsService customUserDetailsService, JwtTokenUtil jwtTokenUtil) {
        this.customUserDetailsService = customUserDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        logger.debug("processing authentication for '{}'", httpServletRequest.getRequestURL());

        final String requestHeader = httpServletRequest.getHeader(SecurityConstants.HEADER_STRING);

        String username = null;
        String authToken = null;


        if (requestHeader != null && requestHeader.startsWith(SecurityConstants.TOKEN_PREFIX)) {
//            authToken = requestHeader.replace(SecurityConstants.TOKEN_PREFIX, "");

            authToken = requestHeader.substring(7);

            try {
                username = jwtTokenUtil.getUsernameFromToken(authToken);
            } catch (ExpiredJwtException e) {

                httpServletResponse.setStatus(4001);

                logger.info("Expired JWT token.");
                logger.trace("Expired JWT token trace: {}", e);
            } catch (Exception e) {

                httpServletResponse.setStatus(4002);

                logger.info("Invalid JWT Token.");
                logger.trace("Invalid JWT Token trace: {}", e);
            }

        } else {
            logger.debug("couldn't find bearer string, will ignore the header");
        }

        logger.debug("checking authentication for user '{}'", username);

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            logger.debug("security context was null, so authorizing user");

            UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

            if (jwtTokenUtil.validateToken(authToken, userDetails)) {

                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                logger.info("authorized user '{}', setting security context", username);
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            }

        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }
}

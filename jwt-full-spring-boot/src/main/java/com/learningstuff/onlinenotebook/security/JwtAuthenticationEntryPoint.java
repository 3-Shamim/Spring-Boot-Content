package com.learningstuff.onlinenotebook.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
        // This is invoked when user tries to access a secured REST resource without supplying any credentials
        // We should just send a 401 Unauthorized response because there is no 'login page' to redirect to


        switch (httpServletResponse.getStatus()) {

            case 4001:
                httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token-Expired");
                break;
            case 4002:
                httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token-Invalid");
                break;
            default:
                httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        }

    }
}

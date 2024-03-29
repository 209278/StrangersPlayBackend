package com.spb.StrangersPlayBackend.security;

import com.spb.StrangersPlayBackend.model.AccountModel;
import com.spb.StrangersPlayBackend.repository.MyUserPrincipal;
import org.json.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
            HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        MyUserPrincipal user = (MyUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        response.getWriter().write(new JSONObject()
                .put("httpCode",200)
                .put("message", "Logged")
                .put("userId", user.getUser().getId()).toString());
    }
}

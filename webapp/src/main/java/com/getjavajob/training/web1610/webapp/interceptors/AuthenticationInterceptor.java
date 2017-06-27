package com.getjavajob.training.web1610.webapp.interceptors;


import com.getjavajob.training.web1610.common.Account;
import com.getjavajob.training.web1610.service.AccountService;
import com.getjavajob.training.web1610.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private AccountService accountService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute("account") == null && searchCookie(request, "email") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        } else if (session.getAttribute("account") == null) {
            if (searchCookie(request, "email") != null) {
                try {
                    Account account = accountService.getByEmail(searchCookie(request, "email").getValue());
                    session.setAttribute("account", account);
                } catch (ServiceException e) {
                    e.printStackTrace();
                }
            }
        }
        return super.preHandle(request, response, handler);
    }

    private Cookie searchCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }
        Cookie cookieEmail = null;
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals(cookieName)) {
                cookieEmail = cookies[i];
            }
        }
        return cookieEmail;
    }
}
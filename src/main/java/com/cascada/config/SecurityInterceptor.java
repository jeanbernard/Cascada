package com.cascada.config;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Jalissa on 12/5/2015.
 */

@Component
public class SecurityInterceptor  extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        Object logged = request.getSession().getAttribute("nombreUsuario");

        if(logged == null){
            response.sendRedirect("/");
        }

        return true;
    }

}

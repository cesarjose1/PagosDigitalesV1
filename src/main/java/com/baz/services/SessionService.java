package com.baz.services;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@SessionScope
public class SessionService {

    public String init() {
        // Tareas de inicialización
        String id = obtenerIdSesion();
        System.out.println("Mostrando id session... " + id);
        return id;
    }


    private String obtenerIdSesion() {
        ServletRequestAttributes servletRequestAttributes =
                (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        String session = servletRequestAttributes.getSessionId();
        return session;
    }
}

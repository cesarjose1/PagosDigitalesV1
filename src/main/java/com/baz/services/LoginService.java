package com.baz.services;

import java.util.HashMap;
import java.util.Map;

public class LoginService {
    private static LoginService instance;
    private boolean estaAutenticado;

    private LoginService() {
        estaAutenticado = false;
    }

    public static synchronized LoginService getInstance() {
        System.out.println("crea isntancia LoginService");
        if (instance == null) {
            instance = new LoginService();
        }
        return instance;
    }

    public boolean usuarioEstaAutenticado() {
        return estaAutenticado;
    }

    public void autenticacion(String usuario, String contrasenia) {
        System.out.println("usuario: " + usuario + ", contraseña: " + contrasenia);
        Map<String, String> usuariosContrasenias = new HashMap<>();
        usuariosContrasenias.put("cesar", "root");
        usuariosContrasenias.put("jose", "password");

        if (usuario != null && !usuario.isEmpty() && contrasenia != null && !contrasenia.isEmpty()) {
            String contraseniaCorrecta = usuariosContrasenias.get(usuario);
            if (contraseniaCorrecta != null && contraseniaCorrecta.equals(contrasenia)) {
                estaAutenticado = true;
            } else {
                estaAutenticado = false;
            }
        } else {
            estaAutenticado = false;
        }
    }

    public void logout() {
        estaAutenticado = false;
    }
}

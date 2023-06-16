package com.baz.notificaciones.enmascarar;

public class Enmascara {
    public static String enmascara(String cadena) {
        //Solo agrega * despues de cuatro alfanumericos
        String cadenaModificada = cadena.replaceAll("^(.{4}).*", "$1" + "*".repeat(cadena.length() - 4));
        return cadenaModificada;
    }
}

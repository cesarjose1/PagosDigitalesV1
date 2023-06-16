package com.baz.notificaciones;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Push push= new Push();
        push.setReferencia("Renta");
        push.setMonto(100);
        push.setNombreBeneficiario("Martha");
        push.setNombrePagador("Cesar");

        Enviar enviar = new Enviar();
        enviar.enviarPush(push);
    }
}
package com.baz.notificaciones;

import javax.swing.*;

public class Enviar {
    public boolean enviarPush(Push push) {
        System.out.println("Se envio push");
        String[] opciones = {"Pagar"};
        int respuesta = JOptionPane.showOptionDialog(null,
                push.getNombrePagador() + ", " + push.getNombreBeneficiario() +
                        " solicita el pago por: $" + push.getMonto(),
                "Pagar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        return respuesta==0;

    }
}
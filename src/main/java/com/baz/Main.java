package com.baz;


import com.baz.notificaciones.Enviar;
import com.baz.notificaciones.Push;
import com.baz.services.PagarService;

import static com.baz.services.PagarService.obtenerNomBeneficiarioConReflexion;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {

        //Se crea una push para ser envia a la persona que va a pagar
        Push push= new Push();
        push.setReferencia("Comida");
        push.setMonto(200);
        push.setNombreBeneficiario("Francisco");
        push.setNombrePagador("Jose");

        //Se modifica el valor del nombre beneficiario para enmascararlo en la push
        String nomBeneficiario= obtenerNomBeneficiarioConReflexion(push,"getNombreBeneficiario");
        push.enmascararNomBeneficiario(nomBeneficiario);

        //Se envia la push y con base a la respuesta validamos si se paga o se rechaza la transaccion
        Enviar enviar = new Enviar();
        boolean pagado=enviar.enviarPush(push);

        //Se valida si se paga o se rechaza el pago
        PagarService.pagar(push,pagado);

    }


}
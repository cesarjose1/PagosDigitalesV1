package com.baz.services;

import com.baz.model.Pago;
import com.baz.notificaciones.Push;
import com.baz.repository.PagoRepository;
//import com.baz.repository.PagoTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@Transactional
@Component
@Scope("prototype")
public class PagarService {
//    @Autowired
//    private PagoTransactionRepository repository;

    @Autowired
    private PagoRepository pagoRepository;
    public static void pagar(Push push, boolean pagado) {
        if (pagado) {
            System.out.println("El pago se realizo correctamente a: " + push.getNombreBeneficiario());
        } else {
            System.out.println("Se rechazo el pago");
        }
    }

    public static String obtenerNomBeneficiarioConReflexion(Push p, String metodo) {
        try {
            Class<? extends Push> extraerInformacionPush = p.getClass();
            Method method = extraerInformacionPush.getMethod(metodo);
            return (String) method.invoke(p);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            System.out.println("No se encontro metodo: " + e.getMessage());
        }
        return "";
    }

//    public Pago crearPagoBD(Pago pago) {
//        return repository.registraPago(pago);
//    }

    public Flux<Pago> obtenerPagos() {
        return pagoRepository.findAll().switchIfEmpty(Flux.empty());
    }

    public Mono<Pago> registarPago(Pago pago) {
        return pagoRepository.save(pago);
    }
}

package com.baz.controller;

import com.baz.model.Pago;
import com.baz.notificaciones.Enviar;
import com.baz.notificaciones.Push;
import com.baz.services.PagarService;
import com.baz.services.LoginService;

import com.baz.services.SessionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicLong;

import static com.baz.services.PagarService.obtenerNomBeneficiarioConReflexion;


@RestController
@RequestMapping("/api/")
public class PagosController {

    private AtomicLong id = new AtomicLong(1L);
    @Autowired
    private SessionService session;

    @Autowired
    private PagarService pagar;

//    @Autowired
//    private PagoTransactionRepository repository;

    @GetMapping("login")
    public ResponseEntity<String> login() {
        System.out.println("###########################################################################  Bean Scope - Singleton");
        String nombreCliente = "cesar";
        // Autenticación
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        LoginService login = (LoginService) factory.getBean("loginService");

        login.autenticacion(nombreCliente, "root");

        if (login.usuarioEstaAutenticado()) {
            return ResponseEntity.ok("El login con singleton y Bean Factory");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }

    }

//    @GetMapping("pagar")
//    public ResponseEntity<String> pagar(boolean pagado) {
//        System.out.println("###########################################################################  Bean Scope - Prototype");
//        String nombreCliente = "cesar";
//        //Se crea una push para ser envia a la persona que va a pagar
//        Push push = new Push();
//        push.setReferencia("Renta");
//        push.setMonto(2000);
//        push.setNombreBeneficiario("Francisco");
//        push.setNombrePagador(nombreCliente);
//
//        //Se modifica el valor del nombre beneficiario para enmascararlo en la push
//        String nomBeneficiario = obtenerNomBeneficiarioConReflexion(push, "getNombreBeneficiario");
//        push.enmascararNomBeneficiario(nomBeneficiario);
//
//        //Se envia la push y con base a la respuesta validamos si se paga o se rechaza la transaccion
//        Enviar enviar = new Enviar();
//
//        //Se valida si se paga
//        pagar.pagar(push, pagado);
//
//        //Registra pago en BD
//        Pago pago= new Pago();
//        BeanUtils.copyProperties(push, pago);
//        pago.setId(id.getAndIncrement());
//        repository.registraPago(pago);
//
//        return ResponseEntity.ok("El pago " + (pagado ? "se realizo correctamente" : "fue rechazado"));
//
//
//    }

    @GetMapping("sesion")
    public ResponseEntity<String> obtenerSession() {
        System.out.println("###########################################################################  Bean Scope - Session");
        return ResponseEntity.ok("Tu session sigue activa: " + session.init());


    }

//    @PostMapping("guarda/pago/bd")
//    public ResponseEntity<Pago> saveCharacter(@RequestBody Pago pago) {
//        pago.setId(id.getAndIncrement());
//        return ResponseEntity.ok(pagar.crearPagoBD(pago));
//    }

    @GetMapping("obtener/pagos/flux")
    public Flux<Pago> obtenerPagos() {
        return pagar.obtenerPagos();
    }

    @PostMapping("registra/pago")
    public Mono<Pago> saveCharacter(@RequestBody Pago pago) {
        return pagar.registarPago(pago);
    }
}

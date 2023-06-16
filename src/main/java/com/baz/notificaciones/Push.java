package com.baz.notificaciones;

import com.baz.notificaciones.enmascarar.Enmascara;

public class Push {
    private int monto;
    private String referencia;
    private String nombreBeneficiario;
    private String nombrePagador;

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNombreBeneficiario() {
        return nombreBeneficiario;
    }

    public void setNombreBeneficiario(String nombreBeneficiario) {
        this.nombreBeneficiario = nombreBeneficiario;
    }

    public String getNombrePagador() {
        return nombrePagador;
    }

    public void setNombrePagador(String nombrePagador) {
        this.nombrePagador = nombrePagador;
    }

    public void enmascararNomBeneficiario(String nombreBeneficiario){
        this.nombreBeneficiario= Enmascara.enmascara(nombreBeneficiario);
    }
}

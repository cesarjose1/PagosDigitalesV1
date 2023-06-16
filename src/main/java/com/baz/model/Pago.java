package com.baz.model;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

//@Entity
//@Table(name = "Pagos")
@Table("Pagos")
public class Pago {
//    @Id
//    @Column(name = "id", nullable = false)
    private Long id;
    private int monto;
    private String referencia;

    @Column("nombreBeneficiario")
    private String nombreBeneficiario;
    @Column("nombrePagador")
    private String nombrePagador;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Pago{" +
                "id=" + id +
                ", monto=" + monto +
                ", referencia='" + referencia + '\'' +
                ", nombreBeneficiario='" + nombreBeneficiario + '\'' +
                ", nombrePagador='" + nombrePagador + '\'' +
                '}';
    }
}

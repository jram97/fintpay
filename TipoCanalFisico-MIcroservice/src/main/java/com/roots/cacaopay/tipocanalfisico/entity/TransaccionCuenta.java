package com.roots.cacaopay.tipocanalfisico.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Javier Ramirez
 */
@Entity
@Table(name = "transaccioncuenta", catalog = "postgres", schema = "public")
public class TransaccionCuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 50)
    @Column(name = "referencia")
    private String referencia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private BigDecimal monto;
    @Column(name = "estado")
    private Short estado;
    @Column(name = "aplicado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date aplicado;
    @Column(name = "contabilizado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date contabilizado;
    @JsonIgnore
    @JoinColumn(name = "canalfisico", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CanalFisico canalfisico;
    @JoinColumn(name = "cuenta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cuenta cuenta;
    @JoinColumn(name = "tipotransaccion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoTransaccion tipotransaccion;
    @JoinColumn(name = "transaccion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Transaccion transaccion;

    public TransaccionCuenta() {
    }

    public TransaccionCuenta(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Short getEstado() {
        return estado;
    }

    public void setEstado(Short estado) {
        this.estado = estado;
    }

    public Date getAplicado() {
        return aplicado;
    }

    public void setAplicado(Date aplicado) {
        this.aplicado = aplicado;
    }

    public Date getContabilizado() {
        return contabilizado;
    }

    public void setContabilizado(Date contabilizado) {
        this.contabilizado = contabilizado;
    }

    public CanalFisico getCanalfisico() {
        return canalfisico;
    }

    public void setCanalfisico(CanalFisico canalfisico) {
        this.canalfisico = canalfisico;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public TipoTransaccion getTipotransaccion() {
        return tipotransaccion;
    }

    public void setTipotransaccion(TipoTransaccion tipotransaccion) {
        this.tipotransaccion = tipotransaccion;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }
}

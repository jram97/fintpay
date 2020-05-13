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

/**
 *
 * @author Javier Ramirez
 */
@Entity
@Table(name = "controlcuenta", catalog = "postgres", schema = "public")
public class ControlCuenta implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "entrada")
    private BigDecimal entrada;
    @Column(name = "salida")
    private BigDecimal salida;
    @JoinColumn(name = "cuenta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cuenta cuenta;
    @JoinColumn(name = "regladefinicion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ReglaDefinicion regladefinicion;

    public ControlCuenta() {
    }

    public ControlCuenta(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getEntrada() {
        return entrada;
    }

    public void setEntrada(BigDecimal entrada) {
        this.entrada = entrada;
    }

    public BigDecimal getSalida() {
        return salida;
    }

    public void setSalida(BigDecimal salida) {
        this.salida = salida;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public ReglaDefinicion getRegladefinicion() {
        return regladefinicion;
    }

    public void setRegladefinicion(ReglaDefinicion regladefinicion) {
        this.regladefinicion = regladefinicion;
    }
	
}

package com.roots.cacaopay.tipocanalfisico.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Javier Ramirez
 */
@Entity
@Table(name = "regladefinicion", catalog = "postgres", schema = "public")
public class ReglaDefinicion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "origen")
    private Short origen;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "maximodiario")
    private BigDecimal maximodiario;
    @Column(name = "maximooperacion")
    private BigDecimal maximooperacion;
    @JoinColumn(name = "definicioncuenta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DefinicionCuenta definicioncuenta;
    @JoinColumn(name = "tipotransaccion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoTransaccion tipotransaccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regladefinicion")
    private List<ControlCuenta> controlcuentaList;

    public ReglaDefinicion() {
    }

    public ReglaDefinicion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getOrigen() {
        return origen;
    }

    public void setOrigen(Short origen) {
        this.origen = origen;
    }

    public BigDecimal getMaximodiario() {
        return maximodiario;
    }

    public void setMaximodiario(BigDecimal maximodiario) {
        this.maximodiario = maximodiario;
    }

    public BigDecimal getMaximooperacion() {
        return maximooperacion;
    }

    public void setMaximooperacion(BigDecimal maximooperacion) {
        this.maximooperacion = maximooperacion;
    }

    public DefinicionCuenta getDefinicioncuenta() {
        return definicioncuenta;
    }

    public void setDefinicioncuenta(DefinicionCuenta definicioncuenta) {
        this.definicioncuenta = definicioncuenta;
    }

    public TipoTransaccion getTipotransaccion() {
        return tipotransaccion;
    }

    public void setTipotransaccion(TipoTransaccion tipotransaccion) {
        this.tipotransaccion = tipotransaccion;
    }

    public List<ControlCuenta> getControlcuentaList() {
        return controlcuentaList;
    }

    public void setControlcuentaList(List<ControlCuenta> controlcuentaList) {
        this.controlcuentaList = controlcuentaList;
    }
}

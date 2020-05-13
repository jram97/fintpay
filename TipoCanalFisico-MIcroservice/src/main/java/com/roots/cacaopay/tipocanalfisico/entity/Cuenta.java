package com.roots.cacaopay.tipocanalfisico.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.validation.constraints.Size;

/**
 *
 * @author Javier Ramirez
 */
@Entity
@Table(name = "cuenta", catalog = "postgres", schema = "public")

public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 30)
    @Column(name = "numero")
    private String numero;
    @Column(name = "estado")
    private Short estado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldo")
    private BigDecimal saldo;
    @Column(name = "correlativooperaciones")
    private BigInteger correlativooperaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuenta")
    private List<OperacionRapida> operacionrapidaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuenta")
    private List<TransaccionCuenta> transaccioncuentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuenta")
    private List<CanalCuenta> canalcuentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuenta")
    private List<ControlCuenta> controlcuentaList;
    @JoinColumn(name = "definicioncuenta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DefinicionCuenta definicioncuenta;
    @JoinColumn(name = "sistemafisico", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SistemaFisico sistemafisico;

    public Cuenta() {
    }

    public Cuenta(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Short getEstado() {
        return estado;
    }

    public void setEstado(Short estado) {
        this.estado = estado;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigInteger getCorrelativooperaciones() {
        return correlativooperaciones;
    }

    public void setCorrelativooperaciones(BigInteger correlativooperaciones) {
        this.correlativooperaciones = correlativooperaciones;
    }

    public List<OperacionRapida> getOperacionrapidaList() {
        return operacionrapidaList;
    }

    public void setOperacionrapidaList(List<OperacionRapida> operacionrapidaList) {
        this.operacionrapidaList = operacionrapidaList;
    }

    public List<TransaccionCuenta> getTransaccioncuentaList() {
        return transaccioncuentaList;
    }

    public void setTransaccioncuentaList(List<TransaccionCuenta> transaccioncuentaList) {
        this.transaccioncuentaList = transaccioncuentaList;
    }

    public List<CanalCuenta> getCanalcuentaList() {
        return canalcuentaList;
    }

    public void setCanalcuentaList(List<CanalCuenta> canalcuentaList) {
        this.canalcuentaList = canalcuentaList;
    }

    public List<ControlCuenta> getControlcuentaList() {
        return controlcuentaList;
    }

    public void setControlcuentaList(List<ControlCuenta> controlcuentaList) {
        this.controlcuentaList = controlcuentaList;
    }

    public DefinicionCuenta getDefinicioncuenta() {
        return definicioncuenta;
    }

    public void setDefinicioncuenta(DefinicionCuenta definicioncuenta) {
        this.definicioncuenta = definicioncuenta;
    }

    public SistemaFisico getSistemafisico() {
        return sistemafisico;
    }

    public void setSistemafisico(SistemaFisico sistemafisico) {
        this.sistemafisico = sistemafisico;
    }

}

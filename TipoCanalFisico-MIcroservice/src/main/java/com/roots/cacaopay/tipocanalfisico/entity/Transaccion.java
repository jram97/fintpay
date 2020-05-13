package com.roots.cacaopay.tipocanalfisico.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Javier Ramirez
 */
@Entity
@Table(name = "transaccion", catalog = "postgres", schema = "public")
public class Transaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "fechahora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahora;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 200)
    @Column(name = "identificadorvisual")
    private String identificadorvisual;
    @OneToMany(mappedBy = "transaccion")
    private List<OperacionRapidaTRX> operacionrapidatrxList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transaccion")
    private List<TransaccionCuenta> transaccioncuentaList;

    public Transaccion() {
    }

    public Transaccion(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechahora() {
        return fechahora;
    }

    public void setFechahora(Date fechahora) {
        this.fechahora = fechahora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdentificadorvisual() {
        return identificadorvisual;
    }

    public void setIdentificadorvisual(String identificadorvisual) {
        this.identificadorvisual = identificadorvisual;
    }

    public List<OperacionRapidaTRX> getOperacionrapidatrxList() {
        return operacionrapidatrxList;
    }

    public void setOperacionrapidatrxList(List<OperacionRapidaTRX> operacionrapidatrxList) {
        this.operacionrapidatrxList = operacionrapidatrxList;
    }

    public List<TransaccionCuenta> getTransaccioncuentaList() {
        return transaccioncuentaList;
    }

    public void setTransaccioncuentaList(List<TransaccionCuenta> transaccioncuentaList) {
        this.transaccioncuentaList = transaccioncuentaList;
    }

}

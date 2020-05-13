package com.roots.cacaopay.tipocanalfisico.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "operacionrapida", catalog = "postgres", schema = "public")
public class OperacionRapida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "estado")
    private Short estado;
    @Size(max = 100)
    @Column(name = "identificadorvisual")
    private String identificadorvisual;
    @Column(name = "lecturas")
    private Integer lecturas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private BigDecimal monto;
    @Size(max = 1)
    @Column(name = "esmontodinamico")
    private String esmontodinamico;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creado;
    @Column(name = "ultimalectura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimalectura;
    @Column(name = "finalizado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finalizado;
    @JoinColumn(name = "cuenta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cuenta cuenta;
    @JoinColumn(name = "Operacionrapida", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DefinicionOperacion definicionoperacion;
    @OneToMany(mappedBy = "Operacionrapida")
    private List<OperacionRapidaTRX> operacionrapidatrxList;

    public OperacionRapida() {
    }

    public OperacionRapida(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getEstado() {
        return estado;
    }

    public void setEstado(Short estado) {
        this.estado = estado;
    }

    public String getIdentificadorvisual() {
        return identificadorvisual;
    }

    public void setIdentificadorvisual(String identificadorvisual) {
        this.identificadorvisual = identificadorvisual;
    }

    public Integer getLecturas() {
        return lecturas;
    }

    public void setLecturas(Integer lecturas) {
        this.lecturas = lecturas;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getEsmontodinamico() {
        return esmontodinamico;
    }

    public void setEsmontodinamico(String esmontodinamico) {
        this.esmontodinamico = esmontodinamico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public Date getUltimalectura() {
        return ultimalectura;
    }

    public void setUltimalectura(Date ultimalectura) {
        this.ultimalectura = ultimalectura;
    }

    public Date getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(Date finalizado) {
        this.finalizado = finalizado;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public DefinicionOperacion getDefinicionoperacion() {
        return definicionoperacion;
    }

    public void setDefinicionoperacion(DefinicionOperacion definicionoperacion) {
        this.definicionoperacion = definicionoperacion;
    }

    public List<OperacionRapidaTRX> getOperacionrapidatrxList() {
        return operacionrapidatrxList;
    }

    public void setOperacionrapidatrxList(List<OperacionRapidaTRX> operacionrapidatrxList) {
        this.operacionrapidatrxList = operacionrapidatrxList;
    }

}

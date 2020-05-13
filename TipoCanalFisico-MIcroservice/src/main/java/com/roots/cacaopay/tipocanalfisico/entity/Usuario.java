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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "usuario", catalog = "postgres", schema = "public")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 200)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 200)
    @Column(name = "alias")
    private String alias;
    @Size(max = 600)
    @Column(name = "notificacion")
    private String notificacion;
    @Column(name = "estado")
    private Short estado;
    @Lob
    @Column(name = "clave")
    private byte[] clave;
    @Column(name = "creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creado;
    @Column(name = "activado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date activado;
    @Column(name = "ultimoinicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimoinicio;
    @Size(max = 128)
    @Column(name = "verificacion")
    private String verificacion;
    @Size(max = 1)
    @Column(name = "tipoautenticacion")
    private String tipoautenticacion;
    @Size(max = 600)
    @Column(name = "autenticacionclave")
    private String autenticacionclave;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<Dispositivo> dispositivoList;
    @JoinColumn(name = "entidadimagen", referencedColumnName = "id")
    @ManyToOne
    private EntidadImagen entidadimagen;

    public Usuario() {
    }

    public Usuario(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(String notificacion) {
        this.notificacion = notificacion;
    }

    public Short getEstado() {
        return estado;
    }

    public void setEstado(Short estado) {
        this.estado = estado;
    }

    public byte[] getClave() {
        return clave;
    }

    public void setClave(byte[] clave) {
        this.clave = clave;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public Date getActivado() {
        return activado;
    }

    public void setActivado(Date activado) {
        this.activado = activado;
    }

    public Date getUltimoinicio() {
        return ultimoinicio;
    }

    public void setUltimoinicio(Date ultimoinicio) {
        this.ultimoinicio = ultimoinicio;
    }

    public String getVerificacion() {
        return verificacion;
    }

    public void setVerificacion(String verificacion) {
        this.verificacion = verificacion;
    }

    public String getTipoautenticacion() {
        return tipoautenticacion;
    }

    public void setTipoautenticacion(String tipoautenticacion) {
        this.tipoautenticacion = tipoautenticacion;
    }

    public String getAutenticacionclave() {
        return autenticacionclave;
    }

    public void setAutenticacionclave(String autenticacionclave) {
        this.autenticacionclave = autenticacionclave;
    }

    public List<Dispositivo> getDispositivoList() {
        return dispositivoList;
    }

    public void setDispositivoList(List<Dispositivo> dispositivoList) {
        this.dispositivoList = dispositivoList;
    }

    public EntidadImagen getEntidadimagen() {
        return entidadimagen;
    }

    public void setEntidadimagen(EntidadImagen entidadimagen) {
        this.entidadimagen = entidadimagen;
    }
}

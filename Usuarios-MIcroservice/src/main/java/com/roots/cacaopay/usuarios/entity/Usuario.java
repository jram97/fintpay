package com.roots.cacaopay.usuarios.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    
    @Column(name = "clave")
    private String clave;
    
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

    @JsonIgnoreProperties(value = {"usuario"}, allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Dispositivo> dispositivoList;
    
    @PrePersist
    private void prePersist() {
    	this.creado = new Date();
    }
    
    public Usuario() {
    	this.dispositivoList = new ArrayList<>();
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
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
    	/*this.dispositivoList.clear();
    	dispositivoList.forEach(this::addDispositivoList);*/
    }
    
    public void addDispositivoList(Dispositivo dispositivo) {
        this.dispositivoList.add(dispositivo);
        //dispositivo.setUsuario(this);
    }
    
    public void deleteDispositivoList(Dispositivo dispositivo) {
        this.dispositivoList.remove(dispositivo);
        //dispositivo.setUsuario(null);
    }
}

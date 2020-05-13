package com.roots.cacaopay.tipocanalfisico.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Javier Ramirez
 */
@Entity
@Table(name = "entidadimagen", catalog = "postgres", schema = "public")
public class EntidadImagen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Lob
    @Column(name = "imagen")
    private byte[] imagen;
    @Column(name = "creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creado;
    @Column(name = "actualizado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualizado;
    @JsonIgnore
    @OneToMany(mappedBy = "entidadimagen")
    private List<SistemaFisico> sistemafisicoList;
    @OneToMany(mappedBy = "entidadimagen")
    private List<TipoCanalFisico> tipocanalfisicoList;
    @JsonIgnore
    @OneToMany(mappedBy = "entidadimagen")
    private List<DefinicionOperacion> definicionoperacionList;
    @JsonIgnore
    @OneToMany(mappedBy = "entidadimagen")
    private List<CanalCuenta> canalcuentaList;
    @JsonIgnore
    @OneToMany(mappedBy = "entidadimagen")
    private List<TipoTransaccion> tipotransaccionList;
    @JsonIgnore
    @OneToMany(mappedBy = "entidadimagen")
    private List<DefinicionCuenta> definicioncuentaList;
    @JsonIgnore
    @OneToMany(mappedBy = "entidadimagen")
    private List<AccesoCanalCuenta> accesocanalcuentaList;
    @JsonIgnore
    @OneToMany(mappedBy = "entidadimagen")
    private List<Usuario> usuarioList;

    public EntidadImagen() {
    }

    public EntidadImagen(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public Date getActualizado() {
        return actualizado;
    }

    public void setActualizado(Date actualizado) {
        this.actualizado = actualizado;
    }

    public List<SistemaFisico> getSistemafisicoList() {
        return sistemafisicoList;
    }

    public void setSistemafisicoList(List<SistemaFisico> sistemafisicoList) {
        this.sistemafisicoList = sistemafisicoList;
    }

    public List<TipoCanalFisico> getTipocanalfisicoList() {
        return tipocanalfisicoList;
    }

    public void setTipocanalfisicoList(List<TipoCanalFisico> tipocanalfisicoList) {
        this.tipocanalfisicoList = tipocanalfisicoList;
    }

    public List<DefinicionOperacion> getDefinicionoperacionList() {
        return definicionoperacionList;
    }

    public void setDefinicionoperacionList(List<DefinicionOperacion> definicionoperacionList) {
        this.definicionoperacionList = definicionoperacionList;
    }

    public List<CanalCuenta> getCanalcuentaList() {
        return canalcuentaList;
    }

    public void setCanalcuentaList(List<CanalCuenta> canalcuentaList) {
        this.canalcuentaList = canalcuentaList;
    }

    public List<TipoTransaccion> getTipotransaccionList() {
        return tipotransaccionList;
    }

    public void setTipotransaccionList(List<TipoTransaccion> tipotransaccionList) {
        this.tipotransaccionList = tipotransaccionList;
    }

    public List<DefinicionCuenta> getDefinicioncuentaList() {
        return definicioncuentaList;
    }

    public void setDefinicioncuentaList(List<DefinicionCuenta> definicioncuentaList) {
        this.definicioncuentaList = definicioncuentaList;
    }

    public List<AccesoCanalCuenta> getAccesocanalcuentaList() {
        return accesocanalcuentaList;
    }

    public void setAccesocanalcuentaList(List<AccesoCanalCuenta> accesocanalcuentaList) {
        this.accesocanalcuentaList = accesocanalcuentaList;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

}

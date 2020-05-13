package com.roots.cacaopay.tipocanalfisico.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;


/**
*
* @author Javier Ramirez
*/
@Entity
@Table(name = "accesocanalcuenta", catalog = "postgres", schema = "public")
public class AccesoCanalCuenta implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 200)
    @Column(name = "correoelectronico")
    private String correoelectronico;
    @Size(max = 600)
    @Column(name = "notificacion")
    private String notificacion;
    @Size(max = 30)
    @Column(name = "codigo")
    private String codigo;
    @Lob
    @Column(name = "clave")
    private byte[] clave;
    @Size(max = 128)
    @Column(name = "verificador")
    private String verificador;
    @Column(name = "administracion")
    private Short administracion;
    @JoinColumn(name = "canalcuenta", referencedColumnName = "id")
    @ManyToOne
    private CanalCuenta canalcuenta;
    @JoinColumn(name = "entidadimagen", referencedColumnName = "id")
    @ManyToOne
    private EntidadImagen entidadimagen;

    public AccesoCanalCuenta() {
    }

    public AccesoCanalCuenta(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorreoelectronico() {
        return correoelectronico;
    }

    public void setCorreoelectronico(String correoelectronico) {
        this.correoelectronico = correoelectronico;
    }

    public String getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(String notificacion) {
        this.notificacion = notificacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public byte[] getClave() {
        return clave;
    }

    public void setClave(byte[] clave) {
        this.clave = clave;
    }

    public String getVerificador() {
        return verificador;
    }

    public void setVerificador(String verificador) {
        this.verificador = verificador;
    }

    public Short getAdministracion() {
        return administracion;
    }

    public void setAdministracion(Short administracion) {
        this.administracion = administracion;
    }

    public CanalCuenta getCanalcuenta() {
        return canalcuenta;
    }

    public void setCanalcuenta(CanalCuenta canalcuenta) {
        this.canalcuenta = canalcuenta;
    }

    public EntidadImagen getEntidadimagen() {
        return entidadimagen;
    }

    public void setEntidadimagen(EntidadImagen entidadimagen) {
        this.entidadimagen = entidadimagen;
    }
	
}

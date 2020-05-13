package com.roots.cacaopay.tipocanalfisico.entity;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Javier Ramirez
 */
@Entity
@Table(name = "sistemafisico", catalog = "postgres", schema = "public")
public class SistemaFisico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 10)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 20)
    @Column(name = "numerocuenta")
    private String numerocuenta;
    @Size(max = 8)
    @Column(name = "tipocuenta")
    private String tipocuenta;
    @JoinColumn(name = "entidadimagen", referencedColumnName = "id")
    @ManyToOne
    private EntidadImagen entidadimagen;
    @JsonIgnore
    @OneToMany(mappedBy = "sistemafisico")
    private List<CanalFisico> canalfisicoList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sistemafisico")
    private List<Cuenta> cuentaList;

    public SistemaFisico () {
    }

    public SistemaFisico (Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumerocuenta() {
        return numerocuenta;
    }

    public void setNumerocuenta(String numerocuenta) {
        this.numerocuenta = numerocuenta;
    }

    public String getTipocuenta() {
        return tipocuenta;
    }

    public void setTipocuenta(String tipocuenta) {
        this.tipocuenta = tipocuenta;
    }

    public EntidadImagen getEntidadimagen() {
        return entidadimagen;
    }

    public void setEntidadimagen(EntidadImagen entidadimagen) {
        this.entidadimagen = entidadimagen;
    }

    public List<CanalFisico> getCanalfisicoList() {
        return canalfisicoList;
    }

    public void setCanalfisicoList(List<CanalFisico> canalfisicoList) {
        this.canalfisicoList = canalfisicoList;
    }

    public List<Cuenta> getCuentaList() {
        return cuentaList;
    }

    public void setCuentaList(List<Cuenta> cuentaList) {
        this.cuentaList = cuentaList;
    }
    
}

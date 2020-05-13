package com.roots.cacaopay.tipocanalfisico.entity;


import java.io.Serializable;
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
import javax.validation.constraints.Size;


/**
*
* @author Javier Ramirez
*/
@Entity
@Table(name = "canalcuenta", catalog = "postgres", schema = "public")
public class CanalCuenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 10)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 150)
    @Column(name = "alias")
    private String alias;
    @Column(name = "estado")
    private Short estado;
    @JoinColumn(name = "cuenta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cuenta cuenta;
    @JoinColumn(name = "entidadimagen", referencedColumnName = "id")
    @ManyToOne
    private EntidadImagen entidadimagen;
    @OneToMany(mappedBy = "canalcuenta")
    private List<AccesoCanalCuenta> accesocanalcuentaList;

    public CanalCuenta() {
    }

    public CanalCuenta(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Short getEstado() {
        return estado;
    }

    public void setEstado(Short estado) {
        this.estado = estado;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public EntidadImagen getEntidadimagen() {
        return entidadimagen;
    }

    public void setEntidadimagen(EntidadImagen entidadimagen) {
        this.entidadimagen = entidadimagen;
    }

    public List<AccesoCanalCuenta> getAccesocanalcuentaList() {
        return accesocanalcuentaList;
    }

    public void setAccesocanalcuentaList(List<AccesoCanalCuenta> accesocanalcuentaList) {
        this.accesocanalcuentaList = accesocanalcuentaList;
    }
    
}

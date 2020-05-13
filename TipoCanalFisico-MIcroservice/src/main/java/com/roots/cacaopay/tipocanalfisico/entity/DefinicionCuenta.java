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
import javax.validation.constraints.Size;

/**
 *
 * @author Javier Ramirez
 */
@Entity
@Table(name = "definicioncuenta", catalog = "postgres", schema = "public")
public class DefinicionCuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 5)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "maximosaldo")
    private BigDecimal maximosaldo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "definicioncuenta")
    private List<ReglaDefinicion> regladefinicionList;
    @JoinColumn(name = "entidadimagen", referencedColumnName = "id")
    @ManyToOne
    private EntidadImagen entidadimagen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "definicioncuenta")
    private List<Cuenta> cuentaList;

    public DefinicionCuenta() {
    }

    public DefinicionCuenta(Integer id) {
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

    public BigDecimal getMaximosaldo() {
        return maximosaldo;
    }

    public void setMaximosaldo(BigDecimal maximosaldo) {
        this.maximosaldo = maximosaldo;
    }

    public List<ReglaDefinicion> getRegladefinicionList() {
        return regladefinicionList;
    }

    public void setRegladefinicionList(List<ReglaDefinicion> regladefinicionList) {
        this.regladefinicionList = regladefinicionList;
    }

    public EntidadImagen getEntidadimagen() {
        return entidadimagen;
    }

    public void setEntidadimagen(EntidadImagen entidadimagen) {
        this.entidadimagen = entidadimagen;
    }

    public List<Cuenta> getCuentaList() {
        return cuentaList;
    }

    public void setCuentaList(List<Cuenta> cuentaList) {
        this.cuentaList = cuentaList;
    }
}

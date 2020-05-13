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


/**
 *
 * @author Javier Ramirez
 */
@Entity
@Table(name = "tipotransaccion", catalog = "postgres", schema = "public")
public class TipoTransaccion implements Serializable {

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
    @Size(max = 1)
    @Column(name = "fisica")
    private String fisica;
    @Column(name = "efectocontable")
    private Short efectocontable;
    @Column(name = "efectosaldo")
    private Short efectosaldo;
    @OneToMany(mappedBy = "tipotransacciondestino")
    private List<DefinicionOperacion> definicionoperacionList;
    @OneToMany(mappedBy = "tipotransaccionorigen")
    private List<DefinicionOperacion> definicionoperacionList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipotransaccion")
    private List<ReglaDefinicion> regladefinicionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipotransaccion")
    private List<TransaccionCuenta> transaccioncuentaList;
    @JoinColumn(name = "entidadimagen", referencedColumnName = "id")
    @ManyToOne
    private EntidadImagen entidadimagen;

    public TipoTransaccion() {
    }

    public TipoTransaccion(Integer id) {
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

    public String getFisica() {
        return fisica;
    }

    public void setFisica(String fisica) {
        this.fisica = fisica;
    }

    public Short getEfectocontable() {
        return efectocontable;
    }

    public void setEfectocontable(Short efectocontable) {
        this.efectocontable = efectocontable;
    }

    public Short getEfectosaldo() {
        return efectosaldo;
    }

    public void setEfectosaldo(Short efectosaldo) {
        this.efectosaldo = efectosaldo;
    }

    public List<DefinicionOperacion> getDefinicionoperacionList() {
        return definicionoperacionList;
    }

    public void setDefinicionoperacionList(List<DefinicionOperacion> definicionoperacionList) {
        this.definicionoperacionList = definicionoperacionList;
    }

    public List<DefinicionOperacion> getDefinicionoperacionList1() {
        return definicionoperacionList1;
    }

    public void setDefinicionoperacionList1(List<DefinicionOperacion> definicionoperacionList1) {
        this.definicionoperacionList1 = definicionoperacionList1;
    }

    public List<ReglaDefinicion> getRegladefinicionList() {
        return regladefinicionList;
    }

    public void setRegladefinicionList(List<ReglaDefinicion> regladefinicionList) {
        this.regladefinicionList = regladefinicionList;
    }

    public List<TransaccionCuenta> getTransaccioncuentaList() {
        return transaccioncuentaList;
    }

    public void setTransaccioncuentaList(List<TransaccionCuenta> transaccioncuentaList) {
        this.transaccioncuentaList = transaccioncuentaList;
    }

    public EntidadImagen getEntidadimagen() {
        return entidadimagen;
    }

    public void setEntidadimagen(EntidadImagen entidadimagen) {
        this.entidadimagen = entidadimagen;
    }
    
}

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Javier Ramirez
 */
@Entity
@Table(name = "definicionoperacion", catalog = "postgres", schema = "public")
public class DefinicionOperacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "prefijo")
    private String prefijo;
    @Column(name = "vigenciahoras")
    private Short vigenciahoras;
    @Size(max = 150)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "maximoparticipantes")
    private Integer maximoparticipantes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "definicionoperacion")
    private List<OperacionRapida> operacionrapidaList;
    @JoinColumn(name = "entidadimagen", referencedColumnName = "id")
    @ManyToOne
    private EntidadImagen entidadimagen;
    @JoinColumn(name = "tipotransacciondestino", referencedColumnName = "id")
    @ManyToOne
    private TipoTransaccion tipotransacciondestino;
    @JoinColumn(name = "tipotransaccionorigen", referencedColumnName = "id")
    @ManyToOne
    private TipoTransaccion tipotransaccionorigen;

    public DefinicionOperacion() {
    }

    public DefinicionOperacion(Integer id) {
        this.id = id;
    }

    public DefinicionOperacion(Integer id, String prefijo) {
        this.id = id;
        this.prefijo = prefijo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public Short getVigenciahoras() {
        return vigenciahoras;
    }

    public void setVigenciahoras(Short vigenciahoras) {
        this.vigenciahoras = vigenciahoras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getMaximoparticipantes() {
        return maximoparticipantes;
    }

    public void setMaximoparticipantes(Integer maximoparticipantes) {
        this.maximoparticipantes = maximoparticipantes;
    }

    public List<OperacionRapida> getOperacionrapidaList() {
        return operacionrapidaList;
    }

    public void setOperacionrapidaList(List<OperacionRapida> operacionrapidaList) {
        this.operacionrapidaList = operacionrapidaList;
    }

    public EntidadImagen getEntidadimagen() {
        return entidadimagen;
    }

    public void setEntidadimagen(EntidadImagen entidadimagen) {
        this.entidadimagen = entidadimagen;
    }

    public TipoTransaccion getTipotransacciondestino() {
        return tipotransacciondestino;
    }

    public void setTipotransacciondestino(TipoTransaccion tipotransacciondestino) {
        this.tipotransacciondestino = tipotransacciondestino;
    }

    public TipoTransaccion getTipotransaccionorigen() {
        return tipotransaccionorigen;
    }

    public void setTipotransaccionorigen(TipoTransaccion tipotransaccionorigen) {
        this.tipotransaccionorigen = tipotransaccionorigen;
    }


}

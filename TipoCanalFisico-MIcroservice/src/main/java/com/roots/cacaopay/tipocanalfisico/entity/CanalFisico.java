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
@Table(name = "canalfisico", catalog = "postgres", schema = "public")
public class CanalFisico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 30)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 2000)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "canalfisico")
    private List<TransaccionCuenta> transaccioncuentaList;
    @JoinColumn(name = "sistemafisico", referencedColumnName = "id")
    @ManyToOne
    private SistemaFisico sistemafisico;
    @JoinColumn(name = "tipocanalfisico", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private TipoCanalFisico tipocanalfisico;

    public CanalFisico() {
    }

    public CanalFisico(Long id) {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<TransaccionCuenta> getTransaccioncuentaList() {
        return transaccioncuentaList;
    }

    public void setTransaccioncuentaList(List<TransaccionCuenta> transaccioncuentaList) {
        this.transaccioncuentaList = transaccioncuentaList;
    }

    public SistemaFisico getSistemafisico() {
        return sistemafisico;
    }

    public void setSistemafisico(SistemaFisico sistemafisico) {
        this.sistemafisico = sistemafisico;
    }

    public TipoCanalFisico getTipocanalfisico() {
        return tipocanalfisico;
    }

    public void setTipocanalfisico(TipoCanalFisico tipocanalfisico) {
        this.tipocanalfisico = tipocanalfisico;
    }
	
}

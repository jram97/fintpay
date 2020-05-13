package com.roots.cacaopay.transaccion.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    @Column(name = "id")
    private Long id;

    @Size(max = 5)
    @Column(name = "codigo")
    private String codigo;
    
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "maximosaldo")
    private double maximosaldo;
    
    /*@JsonIgnoreProperties(value = {"dcuenta"}, allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cuenta> cuentaList;*/

    
    public DefinicionCuenta() {
    	//this.cuentaList = new ArrayList<>();
    }

    public DefinicionCuenta(Long id) {
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

    public double getMaximosaldo() {
        return maximosaldo;
    }

    public void setMaximosaldo(double maximosaldo) {
        this.maximosaldo = maximosaldo;
    }

	/*public List<Cuenta> getCuentaList() {
		return cuentaList;
	}

	public void setCuentaList(List<Cuenta> cuentaList) {
		this.cuentaList = cuentaList;
	}*/
    
    @Override
    public boolean equals(Object obj) {
    	if(this == obj) {
    		return true;
    	}
    	if(!(obj instanceof DefinicionCuenta)) {
    		return false;
    	}
    	DefinicionCuenta dc = (DefinicionCuenta) obj;
    	return this.id != null && this.id.equals(dc.getId());
    }
    
}


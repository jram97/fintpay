package com.roots.cacaopay.tipocanalfisico.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Javier Ramirez
 */
@Entity
@Table(name = "OperacionRapidatrx", catalog = "postgres", schema = "public")
public class OperacionRapidaTRX implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "Operacionrapida", referencedColumnName = "id")
    @ManyToOne
    private OperacionRapida Operacionrapida;
    @JoinColumn(name = "transaccion", referencedColumnName = "id")
    @ManyToOne
    private Transaccion transaccion;

    public OperacionRapidaTRX() {
    }

    public OperacionRapidaTRX(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OperacionRapida getOperacionRapida() {
        return Operacionrapida;
    }

    public void setOperacionRapida(OperacionRapida OperacionRapida) {
        this.Operacionrapida = OperacionRapida;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbPedido")
public class Pedido implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pedido;
    
    @Column(name="cant_producto")
    private int cant_producto;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_hora")
    private Date fecha_hora;
    
    @JoinColumn(name="id_proveedor" ,referencedColumnName = "id")
    @ManyToOne
    private Proveedor id_proveedor;
    
    @JoinColumn(name="id_producto" ,referencedColumnName = "id")
    @ManyToOne
    private Producto id_producto;
    
    @JoinColumn(name="id_sucursal" , referencedColumnName = "id")
    @ManyToOne
    private Sucursal id_sucursal;
    
    @JoinColumn(name="id_usuario", referencedColumnName = "id")
    @ManyToOne
    private Usuario id_usuario;
    
    @Column(name="comentarios")
    private String comentarios;
    
    @Column(name="estado")
    private String estado;

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getCant_producto() {
        return cant_producto;
    }

    public void setCant_producto(int cant_producto) {
        this.cant_producto = cant_producto;
    }

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public Proveedor getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(Proveedor id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public Producto getId_producto() {
        return id_producto;
    }

    public void setId_producto(Producto id_producto) {
        this.id_producto = id_producto;
    }

    public Sucursal getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(Sucursal id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id_pedido=" + id_pedido + ", comentarios=" + comentarios + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.id_pedido;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        if (this.id_pedido != other.id_pedido) {
            return false;
        }
        return true;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="tbDetalleVenta")
public class DetalleVenta implements Serializable{
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_detalleventa;
    
    @JoinColumn(name="id_venta", referencedColumnName = "id")
    @ManyToOne
    private Venta id_venta;
    
    @JoinColumn(name="id_platillo" , referencedColumnName = "id")
    @ManyToOne
    private Platillo id_platillo;
    
    @Column(name="cantidad_platillo")
    private int cantidad_platillo;
    
    @JoinColumn(name="id_bebida" , referencedColumnName = "id")
    @ManyToOne
    private  Bebida id_bebida;
    
    @Column(name="cantidad_bebidas")
    private int cantidad_bebidas;
    
    @JoinColumn(name="id_complemento" , referencedColumnName = "id")
    @ManyToOne
    private Complemento id_complemento;
    
    @Column(name="cantidad_complemento")
    private int cantidad_complemento;
    
    @Column(name="precio_compra")
    private double precio_compra;

    public int getId_detalleventa() {
        return id_detalleventa;
    }

    public void setId_detalleventa(int id_detalleventa) {
        this.id_detalleventa = id_detalleventa;
    }

    public Venta getId_venta() {
        return id_venta;
    }

    public void setId_venta(Venta id_venta) {
        this.id_venta = id_venta;
    }

    public Platillo getId_platillo() {
        return id_platillo;
    }

    public void setId_platillo(Platillo id_platillo) {
        this.id_platillo = id_platillo;
    }

    public int getCantidad_platillo() {
        return cantidad_platillo;
    }

    public void setCantidad_platillo(int cantidad_platillo) {
        this.cantidad_platillo = cantidad_platillo;
    }

    public Bebida getId_bebida() {
        return id_bebida;
    }

    public void setId_bebida(Bebida id_bebida) {
        this.id_bebida = id_bebida;
    }

    public int getCantidad_bebidas() {
        return cantidad_bebidas;
    }

    public void setCantidad_bebidas(int cantidad_bebidas) {
        this.cantidad_bebidas = cantidad_bebidas;
    }

    public Complemento getId_complemento() {
        return id_complemento;
    }

    public void setId_complemento(Complemento id_complemento) {
        this.id_complemento = id_complemento;
    }

    public int getCantidad_complemento() {
        return cantidad_complemento;
    }

    public void setCantidad_complemento(int cantidad_complemento) {
        this.cantidad_complemento = cantidad_complemento;
    }

    public double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" + "id_detalleventa=" + id_detalleventa + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id_detalleventa;
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
        final DetalleVenta other = (DetalleVenta) obj;
        if (this.id_detalleventa != other.id_detalleventa) {
            return false;
        }
        return true;
    }
    
    
     
}

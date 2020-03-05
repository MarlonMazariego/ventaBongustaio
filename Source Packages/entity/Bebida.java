/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbBebida")
public class Bebida implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id_bebida ;
    
    @Column(name="nombre_bebida")
    private String nombre_bebida;
    
    @JoinColumn(name="id_tipoBebida" , referencedColumnName = "id")
    @ManyToOne
    private TipoBebida id_tipoBebida;
    
    @Column(name="precio_bebida")
    private double precio_bebida;

    public int getId_bebida() {
        return id_bebida;
    }

    public void setId_bebida(int id_bebida) {
        this.id_bebida = id_bebida;
    }

    public String getNombre_bebida() {
        return nombre_bebida;
    }

    public void setNombre_bebida(String nombre_bebida) {
        this.nombre_bebida = nombre_bebida;
    }

    public TipoBebida getId_tipoBebida() {
        return id_tipoBebida;
    }

    public void setId_tipoBebida(TipoBebida id_tipoBebida) {
        this.id_tipoBebida = id_tipoBebida;
    }

    public double getPrecio_bebida() {
        return precio_bebida;
    }

    public void setPrecio_bebida(double precio_bebida) {
        this.precio_bebida = precio_bebida;
    }

    @Override
    public String toString() {
        return "Bebida{" + "id_bebida=" + id_bebida + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id_bebida;
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
        final Bebida other = (Bebida) obj;
        if (this.id_bebida != other.id_bebida) {
            return false;
        }
        return true;
    }
    
    
}

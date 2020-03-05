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
@Table(name="tbTiempo")
public class Tiempo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tipo;
    
    @Column(name="tipo")
    private String tipo;
    
    @JoinColumn(name="id_tipoSucursal" , referencedColumnName = "id")
    @ManyToOne
    private TipoSucursal id_tipoSucursal;

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public TipoSucursal getId_tipoSucursal() {
        return id_tipoSucursal;
    }

    public void setId_tipoSucursal(TipoSucursal id_tipoSucursal) {
        this.id_tipoSucursal = id_tipoSucursal;
    }

    @Override
    public String toString() {
        return "Tiempo{" + "id_tipo=" + id_tipo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id_tipo;
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
        final Tiempo other = (Tiempo) obj;
        if (this.id_tipo != other.id_tipo) {
            return false;
        }
        return true;
    }
    
    
    
}

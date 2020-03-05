/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author marlon.mazariegousam
 */
@Entity
@Table(name = "tbTipoBebida")
public class TipoBebida implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tipoBebida;
    
    @Column(name = "tipo")
    private String tipo;

    public TipoBebida() {
    }

    public int getId_tipoBebida() {
        return id_tipoBebida;
    }

    public void setId_tipoBebida(int id_tipoBebida) {
        this.id_tipoBebida = id_tipoBebida;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id_tipoBebida;
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
        final TipoBebida other = (TipoBebida) obj;
        if (this.id_tipoBebida != other.id_tipoBebida) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoBebida{" + "id_tipoBebida=" + id_tipoBebida + '}';
    }
    
    
}

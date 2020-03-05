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
@Table(name = "tbCargo")
public class Cargo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cargo;
    
    @Column(name = "cargo")
    private String cargo;

    public Cargo() {
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.id_cargo;
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
        final Cargo other = (Cargo) obj;
        if (this.id_cargo != other.id_cargo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cargo{" + "id_cargo=" + id_cargo + '}';
    }
    
    
}


package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tbTipoComplemento")
public class TipoComplemento implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tipoCom;
    
    @Column(name = "nombre")
    private  String nombreTComp;

    public TipoComplemento() {
    }

    public int getId_tipoCom() {
        return id_tipoCom;
    }

    public void setId_tipoCom(int id_tipoCom) {
        this.id_tipoCom = id_tipoCom;
    }

    public String getNombreTComp() {
        return nombreTComp;
    }

    public void setNombreTComp(String nombreTComp) {
        this.nombreTComp = nombreTComp;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id_tipoCom;
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
        final TipoComplemento other = (TipoComplemento) obj;
        if (this.id_tipoCom != other.id_tipoCom) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoComplemento{" + "id_tipoCom=" + id_tipoCom + '}';
    }
    
    
    
}

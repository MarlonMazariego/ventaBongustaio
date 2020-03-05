
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbscaPlatillo")
public class ScaPlatillo implements Serializable{
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_subCategoria;
    
    @Column(name = "tipo")
    private  String tipoPlatillo;
    
    @JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo")
    @ManyToOne
    private  Tiempo tiempo;

    public ScaPlatillo() {
    }

    public int getId_subCategoria() {
        return id_subCategoria;
    }

    public void setId_subCategoria(int id_subCategoria) {
        this.id_subCategoria = id_subCategoria;
    }

    public String getTipoPlatillo() {
        return tipoPlatillo;
    }

    public void setTipoPlatillo(String tipoPlatillo) {
        this.tipoPlatillo = tipoPlatillo;
    }

    public Tiempo getTiempo() {
        return tiempo;
    }

    public void setTiempo(Tiempo tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id_subCategoria;
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
        final ScaPlatillo other = (ScaPlatillo) obj;
        if (this.id_subCategoria != other.id_subCategoria) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ScaPlatillo{" + "id_subCategoria=" + id_subCategoria + '}';
    }
    
    
    
}

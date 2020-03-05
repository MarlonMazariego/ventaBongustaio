
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
@Table(name = "tbPlatillo")
public class Platillo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id_platillo;
    
    @Column(name = "nombre_platillo")
    private  String nombrePlatillo;
    
    @Column(name = "precio_platillo")
    private  double precioPlatillo;
    
    @Column(name = "costo_platillo")
    private double costoPlatillo;
    
    @JoinColumn(name = "id_subCategoria", referencedColumnName = "id_subCategoria")
    @ManyToOne
    private ScaPlatillo scaPlatillo;

    public Platillo() {
    }

    public int getId_platillo() {
        return id_platillo;
    }

    public void setId_platillo(int id_platillo) {
        this.id_platillo = id_platillo;
    }

    public String getNombrePlatillo() {
        return nombrePlatillo;
    }

    public void setNombrePlatillo(String nombrePlatillo) {
        this.nombrePlatillo = nombrePlatillo;
    }

    public double getPrecioPlatillo() {
        return precioPlatillo;
    }

    public void setPrecioPlatillo(double precioPlatillo) {
        this.precioPlatillo = precioPlatillo;
    }

    public double getCostoPlatillo() {
        return costoPlatillo;
    }

    public void setCostoPlatillo(double costoPlatillo) {
        this.costoPlatillo = costoPlatillo;
    }

    public ScaPlatillo getScaPlatillo() {
        return scaPlatillo;
    }

    public void setScaPlatillo(ScaPlatillo scaPlatillo) {
        this.scaPlatillo = scaPlatillo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id_platillo;
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
        final Platillo other = (Platillo) obj;
        if (this.id_platillo != other.id_platillo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Platillo{" + "id_platillo=" + id_platillo + '}';
    }
    
    
    
}

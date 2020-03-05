
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
@Table(name = "tbDetallePlatillo")
public class DetallePlatillo implements Serializable{
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id_detallePlatillo;

@Column(name = "cantidad_producto")
private int cantidad_producto;

@JoinColumn(name = "id_platillo", referencedColumnName = "id_platillo")
@ManyToOne
private Platillo id_platillo;

@JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
@ManyToOne
private Producto id_producto;

    public int getId_detallePlatillo() {
        return id_detallePlatillo;
    }

    public void setId_detallePlatillo(int id_detallePlatillo) {
        this.id_detallePlatillo = id_detallePlatillo;
    }

    public int getCantidad_producto() {
        return cantidad_producto;
    }

    public void setCantidad_producto(int cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    public Platillo getId_platillo() {
        return id_platillo;
    }

    public void setId_platillo(Platillo id_platillo) {
        this.id_platillo = id_platillo;
    }

    public Producto getId_producto() {
        return id_producto;
    }

    public void setId_producto(Producto id_producto) {
        this.id_producto = id_producto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id_detallePlatillo;
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
        final DetallePlatillo other = (DetallePlatillo) obj;
        if (this.id_detallePlatillo != other.id_detallePlatillo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetallePlatillo{" + "id_detallePlatillo=" + id_detallePlatillo + '}';
    }


    
}

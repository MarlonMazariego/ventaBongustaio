
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
@Table(name = "tbComplemento")
public class Complemento implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_complemento;
    
    @Column(name = "nombre_complemento")
    private String nombre_complemento;
    
    @JoinColumn(name = "id_tipoCom")
    @ManyToOne
    private TipoComplemento id_tipoCom;
    
    @Column(name = "precio_complemento")
    private double precio_complemento;

    public int getId_complemento() {
        return id_complemento;
    }

    public void setId_complemento(int id_complemento) {
        this.id_complemento = id_complemento;
    }

    public String getNombre_complemento() {
        return nombre_complemento;
    }

    public void setNombre_complemento(String nombre_complemento) {
        this.nombre_complemento = nombre_complemento;
    }

    public TipoComplemento getId_tipoCom() {
        return id_tipoCom;
    }

    public void setId_tipoCom(TipoComplemento id_tipoCom) {
        this.id_tipoCom = id_tipoCom;
    }

    public double getPrecio_complemento() {
        return precio_complemento;
    }

    public void setPrecio_complemento(double precio_complemento) {
        this.precio_complemento = precio_complemento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.id_complemento;
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
        final Complemento other = (Complemento) obj;
        if (this.id_complemento != other.id_complemento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Complemento{" + "id_complemento=" + id_complemento + '}';
    }
    
    
}

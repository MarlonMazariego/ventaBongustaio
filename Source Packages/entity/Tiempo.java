package entity;


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
    private int id_tiempo;
    
    @Column(name="tipo")
    private String tipo;
    
    @JoinColumn(name="id_tipoSucursal" , referencedColumnName = "id_tipoSucursal")
    @ManyToOne
    private TipoSucursal id_tipoSucursal;

    public int getId_tiempo() {
        return id_tiempo;
    }

    public void getId_tiempo(int id_tiempo) {
        this.id_tiempo = id_tiempo;
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

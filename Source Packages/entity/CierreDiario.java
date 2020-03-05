
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbCierreDiario")
public class CierreDiario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cierre;
    
    @Column(name = "inv_cierre")
    private int inv_cierre;
    
    @Column(name = "caja_cierre")
    private double caja_cierre;
    
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario id_usuario;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_logout")
    private Date fecha_logout;

    public int getId_cierre() {
        return id_cierre;
    }

    public void setId_cierre(int id_cierre) {
        this.id_cierre = id_cierre;
    }

    public int getInv_cierre() {
        return inv_cierre;
    }

    public void setInv_cierre(int inv_cierre) {
        this.inv_cierre = inv_cierre;
    }

    public double getCaja_cierre() {
        return caja_cierre;
    }

    public void setCaja_cierre(double caja_cierre) {
        this.caja_cierre = caja_cierre;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Date getFecha_logout() {
        return fecha_logout;
    }

    public void setFecha_logout(Date fecha_logout) {
        this.fecha_logout = fecha_logout;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id_cierre;
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
        final CierreDiario other = (CierreDiario) obj;
        if (this.id_cierre != other.id_cierre) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CierreDiario{" + "id_cierre=" + id_cierre + '}';
    }
    
    
    
}

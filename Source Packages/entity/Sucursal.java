
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
@Table(name = "tbsucursal")
public class Sucursal implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sucursal;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "dir")
    private String dir;
    
    @Column(name = "tel")
    private String tel;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_creacion")
    private Date fecha_creacion;
    
    @Column(name = "capital_inicial")
    private double capital_inicial;
    
    @JoinColumn(name = "id_tipoSucursal", referencedColumnName = "id_tipoSucursal")
    @ManyToOne
    private TipoSucursal id_tipoSucursal;

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public double getCapital_inicial() {
        return capital_inicial;
    }

    public void setCapital_inicial(double capital_inicial) {
        this.capital_inicial = capital_inicial;
    }

    public TipoSucursal getId_tipoSucursal() {
        return id_tipoSucursal;
    }

    public void setId_tipoSucursal(TipoSucursal id_tipoSucursal) {
        this.id_tipoSucursal = id_tipoSucursal;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id_sucursal;
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
        final Sucursal other = (Sucursal) obj;
        if (this.id_sucursal != other.id_sucursal) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sucursal{" + "id_sucursal=" + id_sucursal + '}';
    }

    
    
    
}

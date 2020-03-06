
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "tbRegistrosInicio")
public class RegistrosInicio implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_registro;
    
    @Column(name = "inv_inicial")
    private int invInicial;
    
    @Column(name = "caja_inicial")
    private  double caja_inicial;
    
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToMany
    private  Usuario idUsuario;
    
    @Temporal(TemporalType.TIME)
    @Column(name = "fecha_login")
    private  Date fecha_login;
    
    @Column(name = "tipo", nullable = false)
    private short tipo;
    
    public RegistrosInicio() {
    }

    public int getId_registro() {
        return id_registro;
    }

    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }

    public int getInvInicial() {
        return invInicial;
    }

    public void setInvInicial(int invInicial) {
        this.invInicial = invInicial;
    }

    public double getCaja_inicial() {
        return caja_inicial;
    }

    public void setCaja_inicial(double caja_inicial) {
        this.caja_inicial = caja_inicial;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFecha_login() {
        return fecha_login;
    }

    public void setFecha_login(Date fecha_login) {
        this.fecha_login = fecha_login;
    }
    
    public short getTipo() {
        return tipo;
    }

    public void setTipo(short tipo) {
        this.tipo = tipo;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id_registro;
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
        final RegistrosInicio other = (RegistrosInicio) obj;
        if (this.id_registro != other.id_registro) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RegistrosInicio{" + "id_registro=" + id_registro + '}';
    }
    
    

}

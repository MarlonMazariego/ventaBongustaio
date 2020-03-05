
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tbRolesUsuario")
public class RolesUsuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id_rolesUsuario;
    
    @Column(name = "rol")
    private String rolUser;

    public RolesUsuario() {
    }

    public int getId_rolesUsuario() {
        return id_rolesUsuario;
    }

    public void setId_rolesUsuario(int id_rolesUsuario) {
        this.id_rolesUsuario = id_rolesUsuario;
    }

    public String getRolUser() {
        return rolUser;
    }

    public void setRolUser(String rolUser) {
        this.rolUser = rolUser;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id_rolesUsuario;
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
        final RolesUsuario other = (RolesUsuario) obj;
        if (this.id_rolesUsuario != other.id_rolesUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RolesUsuario{" + "id_rolesUsuario=" + id_rolesUsuario + '}';
    }
    
    
}

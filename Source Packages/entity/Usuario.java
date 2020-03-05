
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
@Table(name = "tbUsuario")
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuaro;
    
    @Column(name = "nickName")
    private String nickName;
    
    @Column(name = "pass")
    private String pass;
    
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne
    private Persona id_persona;
    
    @JoinColumn(name = "id_rolesUsuario", referencedColumnName = "id_rolesUsuario")
    @ManyToOne
    private RolesUsuario id_rolesUsuario;

    public int getId_usuaro() {
        return id_usuaro;
    }

    public void setId_usuaro(int id_usuaro) {
        this.id_usuaro = id_usuaro;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Persona getId_persona() {
        return id_persona;
    }

    public void setId_persona(Persona id_persona) {
        this.id_persona = id_persona;
    }

    public RolesUsuario getId_rolesUsuario() {
        return id_rolesUsuario;
    }

    public void setId_rolesUsuario(RolesUsuario id_rolesUsuario) {
        this.id_rolesUsuario = id_rolesUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id_usuaro;
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
        final Usuario other = (Usuario) obj;
        if (this.id_usuaro != other.id_usuaro) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuaro=" + id_usuaro + '}';
    }
    
    
    
}

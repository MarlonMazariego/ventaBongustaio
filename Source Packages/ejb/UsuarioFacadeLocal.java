
package EJB;

import Entity.Usuario;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UsuarioFacadeLocal {
    
     void create (Usuario usuario);
    
    List<Usuario> findAll();
    
    void delete(Usuario usuario);
    
    void edit(Usuario usuario);
    
    Usuario find(Object id);

}

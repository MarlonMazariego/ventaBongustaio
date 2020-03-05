
package EJB;

import Entity.Complemento;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ComplementoFacadeLocal {
    
    void create (Complemento complemento);
    
    List<Complemento> findAll();
    
    void delete(Complemento complemento);
    
    void edit (Complemento complemento);
    
    Complemento find (Object id);
}

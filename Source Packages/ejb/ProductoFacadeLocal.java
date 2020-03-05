
package EJB;

import Entity.Producto;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ProductoFacadeLocal {
    
 void create (Producto producto);
    
    List<Producto> findAll();
    
    void delete(Producto producto);
    
    void edit(Producto producto);
    
    Producto find(Object id);
}
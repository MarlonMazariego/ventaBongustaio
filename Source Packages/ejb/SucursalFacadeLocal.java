
package EJB;

import Entity.Sucursal;
import java.util.List;
import javax.ejb.Local;

@Local
public interface SucursalFacadeLocal {
    
 void create (Sucursal sucursal);
    
    List<Sucursal> findAll();
    
    void delete(Sucursal sucursal);
    
    void edit(Sucursal sucursal);
    
    Sucursal find(Object id);
}

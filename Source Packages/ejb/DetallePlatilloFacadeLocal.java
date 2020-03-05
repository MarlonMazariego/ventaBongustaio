
package EJB;

import Entity.DetallePlatillo;
import java.util.List;
import javax.ejb.Local;

@Local
public interface DetallePlatilloFacadeLocal {
    
 void create (DetallePlatillo detallePlatillo);
    
    List<DetallePlatillo> findAll();
    
    void delete(DetallePlatillo detallePlatillo);
    
    void edit(DetallePlatillo detallePlatillo);
    
    DetallePlatillo find(Object id);
}

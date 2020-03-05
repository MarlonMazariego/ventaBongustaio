
package EJB;

import Entity.CierreDiario;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CierreDiarioFacadeLocal {
    
     void create (CierreDiario cierreDiario);
    
    List<CierreDiario> findAll();
    
    void delete(CierreDiario cierreDiario);
    
    void edit(CierreDiario cierreDiario);
    
    CierreDiario find(Object id);
}

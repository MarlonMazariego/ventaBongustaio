
package EJB;

import Entity.CierreDiario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CierreDiarioFacade extends AbstractFacade<CierreDiario> implements CierreDiarioFacadeLocal{
    
    @PersistenceContext(unitName = "pvb")
    private EntityManager em;
    @Override
    protected EntityManager getEntityManager(){
    return em;
    }
    public CierreDiarioFacade(){
    super (CierreDiario.class);
    }
    
}

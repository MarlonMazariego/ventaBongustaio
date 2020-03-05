
package EJB;

import Entity.DetallePlatillo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DetallePlatilloFacade extends AbstractFacade<DetallePlatillo> implements DetallePlatilloFacadeLocal{
    
    @PersistenceContext(unitName = "pvb")
    private EntityManager em;
    @Override
    protected EntityManager getEntityManager(){
    return em;
    }
    public DetallePlatilloFacade(){
    super (DetallePlatillo.class);
    }
}

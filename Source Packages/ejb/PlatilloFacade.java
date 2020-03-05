
package ejb;

import Entity.Platillo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PlatilloFacade  extends AbstractFacade<Platillo> implements PlatilloFacadeLocal{
    
        @PersistenceContext(unitName = "pvb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public  PlatilloFacade(){
        super(Platillo.class);
    }

    
}


package EJB;

import Entity.Sucursal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SucursalFacade extends AbstractFacade<Sucursal> implements SucursalFacadeLocal{
    @PersistenceContext(unitName = "pvb")
    private EntityManager em;
    @Override
    protected EntityManager getEntityManager(){
    return em;
    }
    public SucursalFacade(){
    super (Sucursal.class);
    }
}

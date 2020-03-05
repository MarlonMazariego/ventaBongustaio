
package ejb;


import Entity.TipoSucursal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TipoSucursalFacade extends AbstractFacade<TipoSucursal> implements TipoSucursalFacadeLocal{
    
       @PersistenceContext(unitName = "pvb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoSucursalFacade() {
        super(TipoSucursal.class);
    }
}

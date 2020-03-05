
package ejb;

import Entity.TipoComplemento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TipoComplementoFacade extends AbstractFacade<TipoComplemento> implements TipoComplementoFacadeLocal{
    
     @PersistenceContext(unitName = "pvb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoComplementoFacade() {
        super(TipoComplemento.class);
    }
}

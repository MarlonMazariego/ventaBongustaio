package ejb;

import Entity.ScaPlatillo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ScaPlatillosFacade extends AbstractFacade<ScaPlatillo> implements ScaPlatilloFacadeLocal {

    @PersistenceContext(unitName = "pvb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ScaPlatillosFacade() {
        super(ScaPlatillo.class);
    }
}

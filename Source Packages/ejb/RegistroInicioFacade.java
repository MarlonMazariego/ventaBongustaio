package ejb;

import Entity.RegistrosInicio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RegistroInicioFacade extends AbstractFacade<RegistrosInicio> implements RegistroInicioFacadeLocal {

    @PersistenceContext(unitName = "pvb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegistroInicioFacade() {
        super(RegistrosInicio.class);
    }
}

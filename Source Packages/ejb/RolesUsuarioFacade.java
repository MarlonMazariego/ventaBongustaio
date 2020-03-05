package ejb;


import Entity.RolesUsuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RolesUsuarioFacade extends AbstractFacade<RolesUsuario> implements RolesUsuariosFacadeLocal {

    @PersistenceContext(unitName = "pvb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolesUsuarioFacade() {
        super(RolesUsuario.class);
    }

}

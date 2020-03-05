
package EJB;

import Entity.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal{
    @PersistenceContext(unitName = "pvb")
    private EntityManager em;
    @Override
    protected EntityManager getEntityManager(){
    return em;
    }
    public UsuarioFacade(){
    super (Usuario.class);
    }
    
}

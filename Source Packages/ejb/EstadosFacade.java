/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Estados;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EstadosFacade extends AbstractFacade<Estados> implements EstadosFacadeLocal {
    
    @PersistenceContext(unitName = "pvb")
    
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public EstadosFacade() {
        super(Estados.class);
    }
    
}

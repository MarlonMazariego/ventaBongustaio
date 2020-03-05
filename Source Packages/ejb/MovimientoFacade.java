/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Movimiento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author marlon.mazariegousam
 */
@Stateless
public class MovimientoFacade extends AbstractFacade<Movimiento> implements MovimientoFacadeLocal{
    @PersistenceContext(name = "pvb")
    private EntityManager em;

    public MovimientoFacade() {
        super(Movimiento.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
}

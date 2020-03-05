/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.TipoBebida;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author marlon.mazariegousam
 */
@Stateless
public class TipoBebidaFacade extends AbstractFacade<TipoBebida> implements TipoBebidaFacadeLocal{
    @PersistenceContext(name = "pvb")
    private EntityManager em;

    public TipoBebidaFacade() {
        super(TipoBebida.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
}

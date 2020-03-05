/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.DetalleProducto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author marlon.mazariegousam
 */
@Stateless
public class DetalleProductoFacade extends AbstractFacade<DetalleProducto> implements DetalleProductoFacadeLocal{
    @PersistenceContext(name = "pvb")
    private EntityManager em;

    public DetalleProductoFacade() {
        super(DetalleProducto.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
}

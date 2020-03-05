/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

@Stateless
public class TiempoFacade extends Abstract<Tiempo> implements TiempoFacadeLocal{
    
    @PersistenceContext(unitName = "")
    
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager(){
    return  em;
    }
    
    public TiempoFacade(){
    super(Tiempo.class);
    }
    
}

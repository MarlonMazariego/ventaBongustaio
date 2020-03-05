/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Local;

/**
 *
 * @author andy.chuyusam
 */
@Local
public interface BebidaFacadeLocal {
    
     
    void create(Bebida bebida);
   
    List<Bebida> findAll();
    
    void edit(Bebida bebida);
    
    void remove(Bebida bebida);
    
    Bebida find(Object id);
}

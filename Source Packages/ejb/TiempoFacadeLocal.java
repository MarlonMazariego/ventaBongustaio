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
public interface TiempoFacadeLocal {
    
    void create(Tiempo tiempo);
    
    List<Tiempo> findAll();
    
    void edit(Tiempo tiempo);
    
    void remove(Tiempo tiempo);
    
    Tiempo find(Object id);
}

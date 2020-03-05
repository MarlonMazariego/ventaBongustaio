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
public interface PersonaFacadeLocal {
    
    void create(Persona persona);
    
    List<Persona> findAll();
    
    void edit(Persona persona);
    
    void remove(Persona persona);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.TipoBebida;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marlon.mazariegousam
 */
@Local
public interface TipoBebidaFacadeLocal {
    void create(TipoBebida tb);
    void edit(TipoBebida tb);
    void delete(TipoBebida tb);
    List<TipoBebida> findAll();
    TipoBebida find(Object id);
    
}

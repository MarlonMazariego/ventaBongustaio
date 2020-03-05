/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Venta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marlon.mazariegousam
 */
@Local
public interface VentaFacadeLocal {
    void create(Venta v);
    void edit(Venta v);
    void delete(Venta v);
    List<Venta> findAll();
    Venta find(Object id);
    
}

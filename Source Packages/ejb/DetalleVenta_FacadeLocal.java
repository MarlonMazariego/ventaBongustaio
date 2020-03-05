/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

/**
 *
 * @author andy.chuyusam
 */
@Local
public interface DetalleVenta_FacadeLocal {
    
     void create(DetalleVenta detalleVenta);
    
    List<DetalleVenta> findAll;
    
    void edit(DetalleVenta detalleVenta);
    
    void remove(DetalleVenta detalleVenta);
    
    DetalleVenta find(Object id);
}

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
public interface PedidoFacadeLocal {
    
    void create(Pedido pedido);
    
    List<Pedido> findAll();
    
    void edit(Pedido pedido);
    
    void remove(Pedido pedido);
    
    Pedido find(Object id);
}

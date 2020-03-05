/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.DetalleProducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marlon.mazariegousam
 */
@Local
public interface DetalleProductoFacadeLocal {
    void create(DetalleProducto det);
    void edit(DetalleProducto det);
    void delete(DetalleProducto det);
    List<DetalleProducto> findAll();
    DetalleProducto find(Object id);
}

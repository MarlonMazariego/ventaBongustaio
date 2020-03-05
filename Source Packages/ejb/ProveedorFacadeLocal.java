/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Proveedor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marlon.mazariegousam
 */
@Local
public interface ProveedorFacadeLocal {
    void create(Proveedor p);
    void edit(Proveedor p);
    void delete(Proveedor p);
    List<Proveedor> findAll();
    Proveedor find(Object id);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Movimiento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marlon.mazariegousam
 */
@Local
public interface MovimientoFacadeLocal {
    void create(Movimiento mov);
    void edit(Movimiento mov);
    void delete(Movimiento mov);
    List<Movimiento> findAll();
    Movimiento find(Object id);
}

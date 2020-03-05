package ejb;

import entity.Cargo;
import java.util.List;
import javax.ejb.Local;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marlon.mazariegousam
 */
@Local
public interface CargoFacadeLocal {
    void create(Cargo c);
    void edit(Cargo c);
    void delete(Cargo c);
    List<Cargo> findAll();
    Cargo find(Object id);
}

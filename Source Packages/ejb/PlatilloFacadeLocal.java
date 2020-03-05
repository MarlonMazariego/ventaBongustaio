package ejb;

import Entity.Platillo;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PlatilloFacadeLocal {

    void create(Platillo encuesta);

    List<Platillo> findAll();

    void edit(Platillo entity);

    void delete(Platillo entity);

    Platillo find(Object id);

}

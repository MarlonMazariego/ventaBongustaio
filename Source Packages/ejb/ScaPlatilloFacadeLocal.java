package ejb;


import Entity.ScaPlatillo;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ScaPlatilloFacadeLocal {

    void create(ScaPlatillo encuesta);

    List<ScaPlatillo> findAll();

    void edit(ScaPlatillo entity);

    void delete(ScaPlatillo entity);

    ScaPlatillo find(Object id);
}

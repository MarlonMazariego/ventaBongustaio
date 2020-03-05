package ejb;

import Entity.Platillo;
import Entity.RegistrosInicio;
import java.util.List;
import javax.ejb.Local;

@Local
public interface RegistroInicioFacadeLocal {

    void create(RegistrosInicio encuesta);

    List<RegistrosInicio> findAll();

    void edit(RegistrosInicio entity);

    void delete(RegistrosInicio entity);

    RegistrosInicio find(Object id);
}

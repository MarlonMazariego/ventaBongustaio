package ejb;

import Entity.TipoComplemento;
import java.util.List;
import javax.ejb.Local;

@Local
public interface TipoComplementoFacadeLocal {

    void create(TipoComplemento encuesta);

    List<TipoComplemento> findAll();

    void edit(TipoComplemento entity);

    void delete(TipoComplemento entity);

    TipoComplemento find(Object id);

}

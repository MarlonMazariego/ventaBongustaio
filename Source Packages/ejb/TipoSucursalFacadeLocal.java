
package ejb;


import Entity.TipoSucursal;
import java.util.List;
import javax.ejb.Local;

@Local
public interface TipoSucursalFacadeLocal {

    void create(TipoSucursal encuesta);

    List<TipoSucursal> findAll();

    void edit(TipoSucursal entity);

    void delete(TipoSucursal entity);

    TipoSucursal find(Object id);

}

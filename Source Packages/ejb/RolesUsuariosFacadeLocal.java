package ejb;

import Entity.RolesUsuario;
import java.util.List;
import javax.ejb.Local;

@Local
public interface RolesUsuariosFacadeLocal {

    void create(RolesUsuario encuesta);

    List<RolesUsuario> findAll();

    void edit(RolesUsuario entity);

    void delete(RolesUsuario entity);

    RolesUsuario find(Object id);
}

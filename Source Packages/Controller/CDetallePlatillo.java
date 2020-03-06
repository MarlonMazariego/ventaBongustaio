package Controller;

import Entity.DetallePlatillo;
import Entity.Platillo;
import Entity.Producto;
import ejb.DetallePlatilloFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;

@Named(value = "cDetallePlatillo")
@SessionScoped
public class CDetallePlatillo implements Serializable {

    @EJB
    private DetallePlatilloFacade detplaEJB;
    private DetallePlatillo detallePlatillo;
    private List<DetallePlatillo> lista;
    private String msj = "";
    private Platillo platillo;
    private Producto producto;

    public DetallePlatillo getDetallePlatillo() {
        return detallePlatillo;
    }

    public void setDetallePlatillo(DetallePlatillo detallePlatillo) {
        this.detallePlatillo = detallePlatillo;
    }

   

    public List<DetallePlatillo> getLista() {
        return lista;
    }

    public void setLista(List<DetallePlatillo> lista) {
        this.lista = lista;
    }

    public Platillo getPlatillo() {
        return platillo;
    }

    public void setPlatillo(Platillo platillo) {
        this.platillo = platillo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @PostConstruct
    public void init() {
        this.detallePlatillo = new DetallePlatillo();
        lista = detplaEJB.findAll();
        platillo = new Platillo();
        producto = new Producto();
    }

    public void create() {
        FacesMessage mensa;
        try {
            detallePlatillo.setId_producto(producto);
            detallePlatillo.setId_platillo(platillo);
            detplaEJB.create(detallePlatillo);
            msj = "Datos actualizados correcatemente";
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", msj);
            platillo = new Platillo();
            producto = new Producto();
        } catch (Exception e) {
            msj = "Error al guardar los datos";
            System.out.println("Error" + e.getMessage());
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msj);
        }
    }

    public void controlAll() {
        try {
            lista = detplaEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void delete(DetallePlatillo dp) {
        FacesMessage mensa;
        try {
            detplaEJB.delete(dp);
            msj = "Datos eliminados correctamente";
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", msj);
        } catch (Exception e) {
             msj = "Error al Eliminar los datos";
            System.out.println("Error" + e.getMessage());
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msj);
        }
    }
    
    public  void update(){
        FacesMessage mensa;
        try {
            detallePlatillo.setId_producto(producto);
            detallePlatillo.setId_platillo(platillo);
            detplaEJB.edit(detallePlatillo);
            msj = "Datos actualizados";
        } catch (Exception e) {
             msj = "Error al Actualizar los datos";
            System.out.println("Error" + e.getMessage());
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msj);
        }
    }
    public  void  find(DetallePlatillo dp){
        try {
            detallePlatillo = detplaEJB.find(dp.getId_detallePlatillo());
            detplaEJB.find(dp.getId_detallePlatillo());
            platillo = detallePlatillo.getId_platillo();
            producto = detallePlatillo.getId_producto();
        } catch (Exception e) {
        }
    }
}

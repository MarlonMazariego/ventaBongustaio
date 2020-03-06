
package Controller;

import Entity.Tiempo;
import Entity.TipoSucursal;
import ejb.TiempoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;

@Named(value = "cTiempo")
@SessionScoped
public class CTiempo  implements Serializable{

    @EJB
    private TiempoFacadeLocal tieEJB;
    private Tiempo tiempo;
    private List<Tiempo> lista;
    private  String msj ="";
    private  TipoSucursal tipoSucursal;

    public Tiempo getTiempo() {
        return tiempo;
    }

    public void setTiempo(Tiempo tiempo) {
        this.tiempo = tiempo;
    }
   
    public List<Tiempo> getLista() {
        lista = tieEJB.findAll();
        return lista;
    }

    public void setLista(List<Tiempo> lista) {
        this.lista = lista;
    }

    public TipoSucursal getTipoSucursal() {
        return tipoSucursal;
    }

    public void setTipoSucursal(TipoSucursal tipoSucursal) {
        this.tipoSucursal = tipoSucursal;
    }
    
    
    @PostConstruct
    public void  init(){
    this.tiempo = new Tiempo();
    lista = tieEJB.findAll();
    tipoSucursal = new TipoSucursal();           
    }
    
    public  void  create(){
        FacesMessage mensa;
        try {
            tiempo.setId_tipoSucursal(tipoSucursal);
            tieEJB.create(tiempo);
            msj = "Datos guardados correctamente";
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", msj);
            tipoSucursal = new TipoSucursal();
            init();
        } catch (Exception e) {
            msj = "Error al guardar los datos";
            System.out.println("ERROR"+e.getMessage());
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msj);
        }
    }
    
    public  void  controlAll(){
        try {
            lista = tieEJB.findAll();
        } catch (Exception e) {
        }
    }
    
    public void  delete(Tiempo tp){
        FacesMessage mensa;
        try {
            tieEJB.delete(tp);
            msj = "Datos eliminados correctamente";
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", msj);
        } catch (Exception e) {
            msj = "Error al guardar los datos";
            System.out.println("Error"+e.getMessage());
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msj);
            
        }
    }
    
    public  void  update(){
        FacesMessage mensa;
        try {
            tiempo.setId_tipoSucursal(tipoSucursal);
            tieEJB.edit(tiempo);
            msj = "Datos actualizados";
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", msj);
        } catch (Exception e) {
            msj = "Error al actualizar datos";
            System.out.println("Error"+e.getMessage());
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msj);
        }
    }
  public void  find(Tiempo tp){
      try {
          tiempo = tieEJB.find(tp.getId_tipo());
          tieEJB.find(tp.getId_tipo());
          tipoSucursal = tiempo.getId_tipoSucursal();
      } catch (Exception e) {
      }
  }
}

package Controller;

import ejb.TipoSucursalFacadeLocal;
import entity.TipoSucursal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author eddie.hernandezusam
 */
@Named(value = "cTipoSucursal")
@SessionScoped
public class CTipoSucursal implements Serializable {

    private TipoSucursalFacadeLocal TsursalEJB;
    private TipoSucursal tsucursal;
    private List<TipoSucursal> lista;

    private String msj;

    public TipoSucursal getTsucursal() {
        return tsucursal;
    }

    public void setTsucursal(TipoSucursal tsucursal) {
        this.tsucursal = tsucursal;
    }

    public List<TipoSucursal> getLista() {
        return lista;
    }

    public void setLista(List<TipoSucursal> lista) {
        this.lista = lista;
    }

    @PostConstruct
    public void init() {
        tsucursal = new TipoSucursal();
    }
    
    public void clear() {
        init();
    }
    
    public void save() {
        try {
            TsursalEJB.create(tsucursal);
            this.msj = "Registro guardado con éxito ";
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFORME", msj);
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            clear();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error Grave : " + e.getMessage();
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ALERTA", msj);
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
    }

    public void delete(TipoSucursal id) {
        try {
            TsursalEJB.delete(id);
            this.msj = "Registro Eliminado con exito";
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFORME", msj);
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } catch (Exception e) {
            e.printStackTrace();
            this.msj ="Error Grave : "+ e.getMessage();
            FacesMessage mensaje= new FacesMessage(FacesMessage.SEVERITY_ERROR,"ALERTA", msj);
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
    }
    
    public void update(){
      try{
      this.TsursalEJB.edit(tsucursal);
      this.msj = "Registro Editado Correctamente";
      FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,"ALERTA", msj);
      FacesContext.getCurrentInstance().addMessage(null,mensaje);
      }catch(Exception e){
      e.printStackTrace();
      this.msj = "Error Grave : "+e.getMessage();
      FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,"ALERTA",msj);
      FacesContext.getCurrentInstance().addMessage(null,mensaje);
      }
    }
    
    public void find(TipoSucursal id){
        try{
        this.tsucursal = id;
        }catch(Exception e){
            System.out.println("Error al Cargar : " + e.getMessage()); 
        }        
    }
}

package Controller;

import Entity.TipoComplemento;
import ejb.TipoComplementoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;

@Named(value = "cTipoComplemento")
@SessionScoped
public class CTipoComplemento implements Serializable {

    @EJB
    private TipoComplementoFacadeLocal tipoComplementEJB;
    private TipoComplemento tipoComplemento;
    private List<TipoComplemento> lista;
    private String msj = "";

    public TipoComplementoFacadeLocal getTipoComplementEJB() {
        return tipoComplementEJB;
    }

    public void setTipoComplementEJB(TipoComplementoFacadeLocal tipoComplementEJB) {
        this.tipoComplementEJB = tipoComplementEJB;
    }

    public List<TipoComplemento> getLista() {
        lista = tipoComplementEJB.findAll();
        return lista;
    }

    public void setLista(List<TipoComplemento> lista) {
        this.lista = lista;
    }

    @PostConstruct
    public void init() {
        this.tipoComplemento = new TipoComplemento();
        lista = tipoComplementEJB.findAll();
       
    }

    public void create() {
        FacesMessage mensa;
        try {
           tipoComplementEJB.create(tipoComplemento);
           msj = "Datos guardados correctamente";
           mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", msj);
           init();
        } catch (Exception e) {
            msj = "Error al guardar"+e.getMessage();
            System.out.println("Error"+e.getMessage());
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msj);
        }
    }
    
    public void controlAll(){
        try {
            lista = tipoComplementEJB.findAll();
        } catch (Exception e) {
        }
    }
    
    public  void  delete(TipoComplemento tc){
        FacesMessage mensa;
        try {
            tipoComplementEJB.delete(tc);
            msj = "Datos eliminados correctamente";
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", msj);
            
        } catch (Exception e) {
            msj = "Error al Eliminar"+e.getMessage();
            System.out.println("Error"+e.getMessage());
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msj);
        }
    }
    
    public  void  update(){
        FacesMessage mensa;
        try {
            tipoComplementEJB.edit(tipoComplemento);
            msj = "Dat  os actualizados";
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", msj);
        } catch (Exception e) {
              msj = "Error al Eliminar"+e.getMessage();
            System.out.println("Error"+e.getMessage());
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msj);
        }
    }
    public  void  find(TipoComplemento tc){
        try {
            tipoComplemento = tipoComplementEJB.find(tc.getId_tipoCom());
            tipoComplementEJB.find(tc.getId_tipoCom());
        } catch (Exception e) {
        }
    }
}


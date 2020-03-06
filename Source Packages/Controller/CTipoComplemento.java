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
    private TipoComplementoFacadeLocal tipComEJB;
    private TipoComplemento tipoComplemento;
    private List<TipoComplemento> lista;
    private String msj = "";

    public TipoComplementoFacadeLocal getTipoComplementEJB() {
        return tipComEJB;
    }

    public void setTipoComplementEJB(TipoComplementoFacadeLocal tipoComplementEJB) {
        this.tipComEJB = tipoComplementEJB;
    }

    public List<TipoComplemento> getLista() {
        lista = tipComEJB.findAll();
        return lista;
    }

    public void setLista(List<TipoComplemento> lista) {
        this.lista = lista;
    }

    @PostConstruct
    public void init() {
        this.tipoComplemento = new TipoComplemento();
        lista = tipComEJB.findAll();
       
    }

    public void create() {
        FacesMessage mensa;
        try {
           tipComEJB.create(tipoComplemento);
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
            lista = tipComEJB.findAll();
        } catch (Exception e) {
        }
    }
    
    public  void  delete(TipoComplemento tc){
        FacesMessage mensa;
        try {
            tipComEJB.delete(tc);
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
            tipComEJB.edit(tipoComplemento);
            msj = "Datos actualizados";
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", msj);
            init();
        } catch (Exception e) {
              msj = "Error al actualizar"+e.getMessage();
            System.out.println("Error"+e.getMessage());
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msj);
        }
    }
    public  void  find(TipoComplemento tc){
        try {
            tipoComplemento = tipComEJB.find(tc.getId_tipoCom());
            tipComEJB.find(tc.getId_tipoCom());
        } catch (Exception e) {
        }
    }
}


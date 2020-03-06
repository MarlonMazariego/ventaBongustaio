
package Controller;

import Entity.Bebida;
import Entity.TipoBebida;
import ejb.BebidaFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;

/**
 *
 * @author claudia.pinedausam
 */
@Named(value = "cBebidas")
@SessionScoped
public class CBebidas implements Serializable{

    @EJB
    private BebidaFacadeLocal bebEJB;
    private  Bebida bebida;
    private  List<Bebida> lista;
    private String msj="";
    private  TipoBebida tipoBebida;

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }

    public List<Bebida> getLista() {
        lista = bebEJB.findAll();
        return lista;
    }

    public void setLista(List<Bebida> lista) {
        this.lista = lista;
    }

    public TipoBebida getTipoBebida() {
        return tipoBebida;
    }

    public void setTipoBebida(TipoBebida tipoBebida) {
        this.tipoBebida = tipoBebida;
    }
  
    @PostConstruct
    public void  init(){
    this.bebida = new Bebida();
    lista = bebEJB.findAll();
    tipoBebida = new TipoBebida();
    }
    
    public  void create(){
        FacesMessage mensa;
        try {
            bebida.setId_tipoBebida(tipoBebida);
            bebEJB.create(bebida);
       msj = "Datos guardados correctamente";
       mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", msj);
       init();
        } catch (Exception e) {
            msj = "Error al guardar los datos";
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msj);
        }
    }
    
    public void  controlAll(){
        try {
            lista = bebEJB.findAll();
        } catch (Exception e) {
        }
    }
    public  void delete(Bebida bd){
        FacesMessage mensa;
        try {
            bebEJB.delete(bd);
            msj = "Error al guardar los datos";
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", msj);
        } catch (Exception e) {
            msj = "Error al Eliminar los datos";
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msj);
        }
    }
    public void update(){
    FacesMessage mensa;
        try {
            bebida.setId_tipoBebida(tipoBebida);
            bebEJB.edit(bebida);
            msj = "Datos actualizados";
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", msj);
        } catch (Exception e) {
            msj = "Error al actualizar los datos";
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msj);
        }
    }
    public  void  find(Bebida bd){
        try {
            bebida = bebEJB.find(bd.getId_bebida());
            bebEJB.find(bd.getId_bebida());
            tipoBebida = bebida.getId_tipoBebida();
        } catch (Exception e) {
        }
    }
    
}

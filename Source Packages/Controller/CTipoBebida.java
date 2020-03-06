package Controller;

import ejb.TipoBebidaFacade;
import entity.TipoBebida;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "cTipoBebida")
@SessionScoped
public class CTipoBebida implements Serializable {

    @EJB
    private TipoBebidaFacadeLocal tipBebEJB;
    private TipoBebida tipBeb;
    private List<TipoBebida> lista;
    private String msj;

//Getter and setter
    public TipoBebida getTipBeb() {
        return tipBeb;
    }

    public void setTipBeb(TipoBebida tipBeb) {
        this.tipBeb = tipBeb;
    }

    public List<TipoBebida> getLista() {
        this.lista = this.tipBebEJB.findAll();
        return lista;
    }

    public void setLista(List<TipoBebida> lista) {
        this.lista = lista;
    }

    @PostConstruct
    public void init() {
        tipBeb = new TipoBebida();
    }

    //Método para limpiar 
    public void clear() {
        tipBeb = new TipoBebida();
    }

    //Método para guardar
    public void save() {
        FacesMessage mensa;
        try {
            tipBebEJB.create(tipBeb);
            msj = "Datos guardados correctamente";
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Comppletado", msj);
            clear();
        } catch (Exception e) {
            msj = "Error al guardar por " + e.getMessage();
            System.out.println("No guarda por " + e.getMessage());
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msj);
        }
        FacesContext.getCurrentInstance().addMessage(msj, mensa);
    }

    //Método para eliminar
    public void delete(TipoBebida id) {
        FacesMessage mensa;
        try {
            this.tipBebEJB.delete(id);
            msj = "Datos eliminados correctamente";
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Comppletado", msj);
        } catch (Exception e) {
            msj = "Error al eliminar por " + e.getMessage();
            System.out.println("No elimina por " + e.getMessage());
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msj);
        }
        FacesContext.getCurrentInstance().addMessage(msj, mensa);
    }

    //Método para actualizar
    public void update() {
        FacesMessage mensa;
        try {
            tipBebEJB.edit(tipBeb);
            msj = "Datos actualizados correctamente";
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Comppletado", msj);
            clear();
        } catch (Exception e) {
            msj = "Error al actualizar por " + e.getMessage();
            System.out.println("No edita por " + e.getMessage());
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msj);
        }
        FacesContext.getCurrentInstance().addMessage(msj, mensa);
    }

    //Método para cargar
    public void find(TipoBebida id) {
        try {
            this.tipBeb = id;
        } catch (Exception e) {
        }
    }
}

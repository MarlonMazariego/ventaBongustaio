package Controller;

import ejb.ScaPlatilloFacadeLocal;
import entity.ScaPlatillo;
import entity.Tiempo;
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
@Named(value = "cSTPlatillo")
@SessionScoped
public class CSTPlatillo implements Serializable {

    private ScaPlatilloFacadeLocal scplatilloEJB;
    private ScaPlatillo scplatillo;
    private List<ScaPlatillo> lista;
    private Tiempo time;
    private String msj;

    public ScaPlatillo getScplatillo() {
        return scplatillo;
    }

    public void setScplatillo(ScaPlatillo scplatillo) {
        this.scplatillo = scplatillo;
    }

    public List<ScaPlatillo> getLista() {
        this.lista = this.scplatilloEJB.findAll();
        return lista;
    }

    public void setLista(List<ScaPlatillo> lista) {
        this.lista = lista;
    }

    public Tiempo getTime() {
        return time;
    }

    public void setTime(Tiempo time) {
        this.time = time;
    }

    @PostConstruct
    public void init() {
        scplatillo = new ScaPlatillo();
        time = new Tiempo();
    }

    public void clear() {
        init();
    }

    public void save() {

        try {
            scplatilloEJB.create(scplatillo);
            this.msj = "Registro guardado con éxito ";
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFORME", msj);
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            clear();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Transaccion fallida";
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ALERTA", msj);
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }

    }

    public void delete(ScaPlatillo id) {
        try {
            this.scplatilloEJB.delete(id);
            this.msj = "Registro Eliminado con éxito ";
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFORME", msj);
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error Grave : " + e.getMessage();
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ALERTA", msj);
        }
    }

    public void update() {
        try {
            this.scplatilloEJB.edit(scplatillo);
            this.msj = "Registro Actualizado con éxito ";
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFORME", msj);
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error Grave : " + e.getMessage();
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ALERTA", msj);
            FacesContext.getCurrentInstance().addMessage(null, mensaje);

        }

    }

    public void find(ScaPlatillo id) {
        try {
            this.scplatillo = id;
        } catch (Exception e) {
            System.out.println("Error al cargar : " + e.getMessage());
        }
    }

    public void show() {
        try {
            System.out.println("owu");
            this.lista = this.scplatilloEJB.findAll();
        } catch (Exception e) {
            System.out.println("Error: ");
            e.printStackTrace();
        }
    }

}

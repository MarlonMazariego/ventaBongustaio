package Controller;

import entity.Platillo;
import entity.ScaPlatillo;
import ejb.PlatilloFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "cPlatillo")
@SessionScoped
public class CPlatillo implements Serializable {

    @EJB
    private PlatilloFacadeLocal platilloEJB;
    private Platillo pla;
    private ScaPlatillo scaPla;
    private List<Platillo> lista;
    private String msj;

    //Métodos getter and setter
    public Platillo getPla() {
        return pla;
    }

    public void setPla(Platillo pla) {
        this.pla = pla;
    }

    public List<Platillo> getLista() {
        this.lista = this.platilloEJB.findAll();
        return lista;
    }

    public void setLista(List<Platillo> lista) {
        this.lista = lista;
    }

    public ScaPlatillo getScaPla() {
        return scaPla;
    }

    public void setScaPla(ScaPlatillo scaPla) {
        this.scaPla = scaPla;
    }
    

    @PostConstruct
    public void init() {
        pla = new Platillo();
       scaPla = new ScaPlatillo();
    }
    //Método para limpiar
    public  void clear(){
        pla = new Platillo();
        scaPla = new ScaPlatillo();
    }
    //Método para guardar
    public void save(){
        FacesMessage mensa;
        try {
            this.pla.setScaPlatillo(scaPla);
            platilloEJB.create(pla);
            msj = "Datos guardados correctamente";
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", msj);
            clear();
        } catch (Exception e) {
            msj = "Error al guardar por " +e.getMessage();
            System.out.println("No guarda por " +e.getMessage());
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msj);
        }
        FacesContext.getCurrentInstance().addMessage(msj, mensa);
    }
    //Método para eliminar
    public void delete(Platillo id){
        FacesMessage mensa;
        try {
            this.platilloEJB.delete(id);
                  msj = "Datos eliminados correctamente";
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", msj);
        } catch (Exception e) {
             msj = "Error al eliminar por " +e.getMessage();
            System.out.println("No elimina por " +e.getMessage());
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msj);
        }
        FacesContext.getCurrentInstance().addMessage(msj, mensa); 
    }
    
    //Método para actualizar
    public void update(){
          FacesMessage mensa;
        try {
            this.pla.setScaPlatillo(scaPla);
            platilloEJB.edit(pla);
                  msj = "Datos actualizados correctamente";
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", msj);
            clear();
        } catch (Exception e) {
            msj = "Error al actualizar por " +e.getMessage();
            System.out.println("No actualiza por " +e.getMessage());
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msj);
        }
       FacesContext.getCurrentInstance().addMessage(msj, mensa);  
    }
    
    //Método para cargar
    public void find(Platillo id){
        try {
            this.scaPla.setId_subCategoria(id.getScaPlatillo().getId_subCategoria());
            this.pla = id;
        } catch (Exception e) {
            System.out.println("No carga por " +e.getMessage());
        }
    }
}

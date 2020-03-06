
package Controller;

import entity.Producto;
import entity.ScaPlatillo;
import ejb.ProductoFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@Named(value = "cProducto")
@SessionScoped
public class CProducto implements Serializable {

    @EJB
    private ProductoFacadeLocal productoEJB;
    private Producto pro;
    private List<Producto> lista;
    private ScaPlatillo scaPla;
    private String msj;

    public Producto getPro() {
        return pro;
    }

    public void setPro(Producto pro) {
        this.pro = pro;
    }

    public List<Producto> getLista() {
        this.lista = this.productoEJB.findAll();
        return lista;
    }

    public void setLista(List<Producto> lista) {
        this.lista = lista;
    }

    public ScaPlatillo getScaPla() {
        return scaPla;
    }

    public void setScaPla(ScaPlatillo scaPla) {
        this.scaPla = scaPla;
    }
    
    @PostConstruct
    public void init(){
    pro = new Producto();
    scaPla = new ScaPlatillo();           
    }
    
    public void clear(){
          pro = new Producto();
    scaPla = new ScaPlatillo();
    }
    
    public void save(){
        FacesMessage mensa;
        try {
            this.pro.setId_sibCategoria(scaPla);
            productoEJB.create(pro);
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
    public void delete(Producto id){
        FacesMessage mensa;
        try {
            this.productoEJB.delete(id);
            msj = "Datos eliminados correctamente";
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", msj);
        } catch (Exception e) {
            msj = "Error al eliminar por " +e.getMessage();
            System.out.println("No elimina por " +e.getMessage());
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msj);
        }
        FacesContext.getCurrentInstance().addMessage(msj, mensa);
    }
    public void update(){
        FacesMessage mensa;
        try {
            this.pro.setId_sibCategoria(scaPla);
            productoEJB.edit(pro);
            msj = "Datos actualizados correctamente";
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", msj);
            clear();
        } catch (Exception e) {
            System.out.println("No actualiza por " +e.getMessage());
        }
    }
    public void find(Producto id){
        try {
            this.scaPla.setId_subCategoria(id.getId_sibCategoria().getId_subCategoria());
            this.pro = id;
        } catch (Exception e) {
        }
    }
}

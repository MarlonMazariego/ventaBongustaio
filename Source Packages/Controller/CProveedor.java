
package controller;

import ejb.ProveedorFacadeLocal;
import entity.Proveedor;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "CProveedor")
@SessionScoped
public class CProveedor implements Serializable{
    
    @EJB
    private ProveedorFacadeLocal proEJB;
    private Proveedor proveedor;
    private List<Proveedor> lista;
    String mensa = "";
    
    public List<Proveedor> getLista(){
    lista = proEJB.findAll();
    return lista;
    }
    public void setLista(List<Proveedor> lista){
    this.lista = lista;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    @PostConstruct
    public void init(){
    proveedor = new Proveedor();
    }
    public void create(){
        FacesMessage message;
        try {
            proEJB.create(proveedor);
            init();
            message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Exito","Datos Guardados");
        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Error al guardar");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public void update(){
    FacesMessage message;
        try {
            proEJB.edit(proveedor);
            init();
            message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Exito","Datos Modificados");
        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Error al Modificar");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public void delete(Proveedor p){
    FacesMessage message;
        try {
            proEJB.delete(p);
            init();
            message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Exito","Datos Eliminados");
        } catch (Exception e) {
         message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Error al Eliminar");   
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public void find(Proveedor id){
        try {
            this.proveedor = this.proEJB.find(id.getId_proveedor());
        } catch (Exception e) {
        }
    }
    
}

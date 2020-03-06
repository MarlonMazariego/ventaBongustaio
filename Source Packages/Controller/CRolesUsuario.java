
package controller;

import ejb.RolesUsuariosFacadeLocal;
import entity.RolesUsuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "CRolesUsuario")
@SessionScoped
public class CRolesUsuario implements Serializable{
    
    @EJB
    private RolesUsuariosFacadeLocal rolusEJB;
    private RolesUsuario rolesUsuario;
    private List<RolesUsuario> lista;
    String mensa = "";
    
    public List<RolesUsuario> getLista(){
    lista = rolusEJB.findAll();
    return lista;
    }
    public void setLista(List<RolesUsuario> lista){
    this.lista = lista;
    }

    public RolesUsuario getRolesUsuario() {
        return rolesUsuario;
    }

    public void setRolesUsuario(RolesUsuario rolesUsuario) {
        this.rolesUsuario = rolesUsuario;
    }
    @PostConstruct
    public void init(){
    rolesUsuario = new RolesUsuario();
    }
    
    public void create(){
        FacesMessage message;
        try {
            rolusEJB.create(rolesUsuario);
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
            rolusEJB.edit(rolesUsuario);
            init();
            message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Exito","Datos Modificados");
        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Error al Modificar");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public void delete(RolesUsuario us){
    FacesMessage message;
        try {
            rolusEJB.delete(us);
            init();
            message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Exito","Datos Eliminados");
        } catch (Exception e) {
         message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Error al Eliminar");   
        }
         FacesContext.getCurrentInstance().addMessage(null, message);
        } 
    public void find(RolesUsuario id){
        try {
            this.rolesUsuario = this.rolusEJB.find(id.getId_rolesUsuario());
        } catch (Exception e) {
        }
    }
}

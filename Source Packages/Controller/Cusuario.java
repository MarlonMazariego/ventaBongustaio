/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import ejb.UsuarioFacadeLocal;
import entity.Persona;
import entity.RolesUsuario;
import entity.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@Named(value = "cusuario")
@SessionScoped
public class Cusuario implements Serializable {

@EJB
private UsuarioFacadeLocal usuarioEJB;
private Usuario usu;
private List<Usuario> lista;
private Persona per;
private RolesUsuario rolUsu;

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public Persona getPer() {
        return per;
    }

    public void setPer(Persona per) {
        this.per = per;
    }

    public RolesUsuario getRolUsu() {
        return rolUsu;
    }

    public void setRolUsu(RolesUsuario rolUsu) {
        this.rolUsu = rolUsu;
    }

    public List<Usuario> getLista() {
        lista = usuarioEJB.findAll();
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }

    @PostConstruct
    public void init(){
        usu = new Usuario();
        rolUsu = new RolesUsuario();
        per = new Persona();
    }
    
    
    public void save(){
        FacesMessage message;
        try {
            usu.setId_persona(per);
            usu.setId_rolesUsuario(rolUsu);
            usuarioEJB.create(usu);
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
            usu.setId_persona(per);
            usu.setId_rolesUsuario(rolUsu);
            usuarioEJB.edit(usu);
            init();
            message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Exito","Datos Modificados");
        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Error al Modificar");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public void delete(Usuario us){
        FacesMessage message;
        try {          
            usuarioEJB.delete(us);
            init();
            message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Exito","Datos Eliminados");
        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Error al Eliminar");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    //Metodo para asignar un empleado al usuario al modificar o crear uno nuevo
    public void assign(Persona pers){
        try {            
            per = pers;
            usu.setId_persona(pers);
            System.out.println(per.getId_persona());            
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error",e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }    
    
    public void find(Usuario us){
        try {
            usu = usuarioEJB.find(us.getId_usuario());
            per.setId_persona(usu.getId_persona().getId_persona());
            rolUsu.setId_rolesUsuario(usu.getId_rolesUsuario().getId_rolesUsuario());
            usuarioEJB.find(usu.getId_usuario());
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error",e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}

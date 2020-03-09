/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ejb.RegistroInicioFacadeLocal;
import entity.RegistrosInicio;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author andy.chuyusam
 */
@Named(value = "cRegistroInicio")
@SessionScoped
public class CRegistroInicio implements Serializable {

  @EJB
  private RegistroInicioFacadeLocal registroEJB;
  private RegistrosInicio registro;
  private List<RegistrosInicio> lista;

    public RegistrosInicio getRegistro() {
        return registro;
    }

    public void setRegistro(RegistrosInicio registro) {
        this.registro = registro;
    }

    public List<RegistrosInicio> getLista() {
        this.lista =  registroEJB.findAll();
        return lista;
    }

    public void setLista(List<RegistrosInicio> lista) {
        this.lista = lista;
    }
  
    @PostConstruct
    public void init(){
    registro = new RegistrosInicio();
    }
    
    public void clear(){
    registro = new RegistrosInicio();
    }
  
 public void refresh() {
        this.lista = registroEJB.findAll();
    }
  

    public void save() {
        FacesMessage mensa = null;
        try {
            this.reg.setIdUsuario(usu);
            this.registroEJB.create(reg);
            init();
            refresh();
            this.msj = "Registro guardado correctamente";
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", msj);
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Ha ocurrido un error mientras se guardaba el registro";
            System.err.println("Error al ingresar registro : " + e.getMessage());
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ups", msj);
        }
        FacesContext.getCurrentInstance().addMessage(msj, mensa);
    }

    public void update() {
        FacesMessage mensa = null;
        try {
            this.reg.setIdUsuario(usu);
            this.registroEJB.edit(reg);
            init();
            refresh();
            this.msj = "Registro guardado correctamente";
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", msj);
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Ha ocurrido un error mientras se guardaba el registro";
            System.err.println("Error al ingresar registro : " + e.getMessage());
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ups", msj);
        }
        FacesContext.getCurrentInstance().addMessage(msj, mensa);
    }

    public void delete(RegistrosInicio id) {
        FacesMessage mensa = null;
        try {
            this.registroEJB.delete(id);
            init();
            refresh();
            this.msj = "Registro eliminado correctamente";
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", msj);
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Ha ocurrido un error mientras se eliminaba el registro";
            System.err.println("Error al ingresar registro : " + e.getMessage());
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ups", msj);
        }
        FacesContext.getCurrentInstance().addMessage(msj, mensa);
    }

    public void findID(RegistrosInicio id) {
        FacesMessage mensa = null;
        try {
            this.usu.setId_usuario(id.getIdUsuario().getId_usuario());
            this.reg = id;
            this.msj = "Registro cargado correctamente";
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", msj);
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "No se pudo cargar la información...";
            System.err.println("Error al ingresar registro : " + e.getMessage());
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ups", msj);
        }
        FacesContext.getCurrentInstance().addMessage(msj, mensa);
    }

}

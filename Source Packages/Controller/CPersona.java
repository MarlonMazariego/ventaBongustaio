/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.PersonaFacadeLocal;
import entity.Cargo;
import entity.Persona;
import entity.Sucursal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@Named(value = "CPersona")
@SessionScoped
public class CPersona implements Serializable{
    
    @EJB
    private PersonaFacadeLocal perEJB;
    private Persona persona;
    private List<Persona> lista;
    private Cargo car;
    private Sucursal suc;
    String mensa = "";
    
    public List<Persona> getLista(){
    lista = perEJB.findAll();
    return lista;
    }
    public void setLista(List<Persona> lista){
    this.lista = lista;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Cargo getCargo() {
        return car;
    }

    public void setCargo(Cargo cargo) {
        this.car = cargo;
    }

    public Sucursal getSucursal() {
        return suc;
    }

    public void setSucursal(Sucursal sucursal) {
        this.suc = sucursal;
    }
    
    @PostConstruct
    public void init(){
    persona = new Persona();
    suc = new Sucursal();
    car = new Cargo();
    
    }
    public void create(){
        FacesMessage message;
        try {
            persona.setId_cargo(car);
            persona.setId_sucursal(suc);
            perEJB.create(persona);
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
            persona.setId_cargo(car);
            persona.setId_sucursal(suc);
            perEJB.edit(persona);
            init();
            message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Exito","Datos Modificados");
        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Error al Modificar");
        }
         FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public void delete(Persona per){
    FacesMessage message;
        try {
            perEJB.delete(per);
            init();
             message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Exito","Datos Eliminados");
        } catch (Exception e) {
             message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Error al Eliminar");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public void find(Persona id){
        try {
            this.persona.setId_cargo(car);
            this.persona.setId_sucursal(suc);
            this.persona = this.perEJB.find(id.getId_persona());
            perEJB.find(persona.getId_persona());
        } catch (Exception e) {
        }
    }
    
}

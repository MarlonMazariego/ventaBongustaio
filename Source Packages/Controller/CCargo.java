/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ejb.CargoFacadeLocal;
import entity.Cargo;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "cCargo")
@SessionScoped
public class CCargo implements Serializable {

    @EJB
    private CargoFacadeLocal cargoEJB;
    private Cargo cargo;
    private List<Cargo> lista;

    private String msj;

    public CargoFacadeLocal getCargoEJB() {
        return cargoEJB;
    }

    public void setCargoEJB(CargoFacadeLocal cargoEJB) {
        this.cargoEJB = cargoEJB;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Cargo> getLista() {
        this.lista = this.cargoEJB.findAll();
        return lista;
    }

    public void setLista(List<Cargo> lista) {
        this.lista = lista;
    }

    @PostConstruct
    public void init() {

        cargo = new Cargo();
    }

    public void clear() {
        init();
    }

    public void save() {

        try {
            cargoEJB.create(cargo);
            this.msj = "Registro guardado con éxito ";
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFORME", msj);
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            clear();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error Grave : " + e.getMessage();
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ALERTA", msj);
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }

    }

    public void delete(Cargo id) {
        try {
            this.cargoEJB.delete(id);
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
            this.cargoEJB.edit(cargo);
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

    public void find(Cargo id) {
        try {
            this.cargo = id;
        } catch (Exception e) {
            System.out.println("Error al cargar : " + e.getMessage());
        }
    }

}

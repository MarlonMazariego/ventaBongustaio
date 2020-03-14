/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.MovimientoFacadeLocal;
import entity.Movimiento;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author fernando.barrazausam
 */
@Named(value = "cMovimiento")
@SessionScoped
public class CMovimiento implements Serializable {

    @EJB
    private MovimientoFacadeLocal movimientoEJB;
    private Movimiento mov;
    private List<Movimiento> lista;

    /*MENSAJE*/
    private String msj;

    public Movimiento getMov() {
        return mov;
    }

    public void setMov(Movimiento mov) {
        this.mov = mov;
    }

    public List<Movimiento> getLista() {
        this.lista = this.movimientoEJB.findAll();
        return lista;
    }

    public void setLista(List<Movimiento> lista) {
        this.lista = lista;
    }

    @PostConstruct
    public void init() {
        this.mov = new Movimiento();
    }

    public void refresh() {
        try {
            this.lista = this.movimientoEJB.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error " + e.getMessage());
        }
    }

    public void update() {
        FacesMessage mensa;
        try {
            this.movimientoEJB.edit(mov);
            init();
            refresh();
            this.msj = "Registro modificado con  éxito";
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación completa", msj);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error al modificar " + e.getMessage());
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Operación fallida", msj);
        }
        FacesContext.getCurrentInstance().addMessage(msj, mensa);
    }

    public void find(Movimiento id) {
        FacesMessage mensa;
        try {
            this.mov = id;
            this.msj = "Registro modificado con  éxito";
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación completa", msj);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error al modificar " + e.getMessage());
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Operación fallida", msj);
        }
        FacesContext.getCurrentInstance().addMessage(msj, mensa);
    }

    public void delete(Movimiento id) {
        FacesMessage mensa;
        try {
            this.movimientoEJB.delete(id);
            this.msj = "Registro eliminado con  éxito";
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación completa", msj);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error al eliminar " + e.getMessage());
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Operación fallida", msj);
        }
        FacesContext.getCurrentInstance().addMessage(msj, mensa);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ejb.MovimientoFacadeLocal;
import entity.Movimiento;
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
@Named(value = "cMovimiento")
@SessionScoped
public class CMovimiento implements Serializable {

    @EJB
    private MovimientoFacadeLocal moviminetoEJB;
    private Movimiento movimiento;
    private List<Movimiento> lista;

    public Movimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    public List<Movimiento> getLista() {
        this.lista = moviminetoEJB.findAll();
        return lista;
    }

    public void setLista(List<Movimiento> lista) {
        this.lista = lista;
    }
    
    @PostConstruct
    public void init(){
    
    movimiento =  new Movimiento();
    }
    
    public void clear(){
    movimiento =  new Movimiento();
    }
    public void consultarAll(){
    lista =  moviminetoEJB.findAll();
    }
    
    public void save(){
    
    moviminetoEJB.create(movimiento);
    }
    
    public void update(){
    moviminetoEJB.edit(movimiento);
    }
    
    public void delete(Movimiento id){
     moviminetoEJB.delete(id);
    }
    
    public void leerId(Movimiento id){
    this.movimiento =  id;
    }
}

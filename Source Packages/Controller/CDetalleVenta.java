/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ejb.DetalleVentaFacadeLocal;
import entity.Bebida;
import entity.Complemento;
import entity.DetalleVenta;
import entity.Platillo;
import entity.Venta;
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
@Named(value = "cDetalleVenta")
@SessionScoped
public class CDetalleVenta implements Serializable {

   @EJB
   private DetalleVentaFacadeLocal detalleventaEJB;
   private DetalleVenta detalleventa;
   private Venta venta;
   private Platillo platillo;
   private Bebida bebida;
   private Complemento complemento;
   private List<DetalleVenta> lista;

    public DetalleVenta getDetalleventa() {
        return detalleventa;
    }

    public void setDetalleventa(DetalleVenta detalleventa) {
        this.detalleventa = detalleventa;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Platillo getPlatillo() {
        return platillo;
    }

    public void setPlatillo(Platillo platillo) {
        this.platillo = platillo;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }

    public Complemento getComplemento() {
        return complemento;
    }

    public void setComplemento(Complemento complemento) {
        this.complemento = complemento;
    }

    public List<DetalleVenta> getLista() {
        this.lista =  detalleventaEJB.findAll();
        return lista;
    }

    public void setLista(List<DetalleVenta> lista) {
        this.lista = lista;
    }
    
   @PostConstruct
   public void init(){
   
       venta = new Venta();
       platillo =  new Platillo();
       bebida =  new Bebida();
       complemento =  new Complemento();
       detalleventa = new DetalleVenta();
               
   }
   
   public void clear(){
   
       venta = new Venta();
       platillo =  new Platillo();
       bebida =  new Bebida();
       complemento =  new Complemento();
       detalleventa = new DetalleVenta();
   }
   public void consultarAll(){
   lista =  detalleventaEJB.findAll();
   }
   
   public void save(){
   
       detalleventa.setId_venta(venta);
       detalleventa.setId_platillo(platillo);
       detalleventa.setId_bebida(bebida);
       detalleventa.setId_complemento(complemento);
       detalleventaEJB.create(detalleventa);
       clear();
       
   }
   
   public void update(){
   detalleventa.setId_venta(venta);
       detalleventa.setId_platillo(platillo);
       detalleventa.setId_bebida(bebida);
       detalleventa.setId_complemento(complemento);
       detalleventaEJB.edit(detalleventa);
   }
   
   public void delete(DetalleVenta id){
   
       detalleventaEJB.delete(id);
   }
   
   public void find(DetalleVenta id){
   
       this.venta.setId_venta(id.getId_venta().getId_venta());
       this.platillo.setId_platillo(id.getId_platillo().getId_platillo());
       this.bebida.setId_bebida(id.getId_bebida().getId_bebida());
       this.complemento.setId_complemento(id.getId_complemento().getId_complemento());
       this.detalleventa = id;
   }
}

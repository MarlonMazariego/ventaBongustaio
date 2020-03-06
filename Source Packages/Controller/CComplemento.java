/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ejb.ComplementoFacadeLocal;
import entity.Complemento;
import entity.TipoComplemento;
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
@Named(value = "complementoController")
@SessionScoped
public class CComplemento implements Serializable {

  @EJB
  private ComplementoFacadeLocal ComplemenetoEJB;
  private  Complemento complemento;
  private TipoComplemento tipocomplemento;
  private List<Complemento> lista;

    public Complemento getComplemento() {
        return complemento;
    }

    public void setComplemento(Complemento complemento) {
        this.complemento = complemento;
    }

    public TipoComplemento getTipocomplemento() {
        return tipocomplemento;
    }

    public void setTipocomplemento(TipoComplemento tipocomplemento) {
        this.tipocomplemento = tipocomplemento;
    }

    public List<Complemento> getLista() {
        this.lista =  ComplemenetoEJB.findAll();
        return lista;
    }

    public void setLista(List<Complemento> lista) {
        this.lista = lista;
    }
           
  @PostConstruct
  public void init(){
  
      complemento = new Complemento();
      tipocomplemento =  new TipoComplemento();
  }
  
  public void limpiar(){
  
      complemento = new Complemento();
      tipocomplemento =  new TipoComplemento();
  }
  
  public void consultarAll(){
  
      lista =  ComplemenetoEJB.findAll();
  }
  
  public void guardar(){
      
      complemento.setId_tipoCom(tipocomplemento);
      ComplemenetoEJB.create(complemento);
     limpiar();
     consultarAll();
  }
  
  public void actualizar(){
  ComplemenetoEJB.edit(complemento);
  }
  
  public void delete(Complemento id){
  ComplemenetoEJB.delete(id);
  }
  
  public void leerId(Complemento id){
  
      this.tipocomplemento.setId_tipoCom(id.getId_tipoCom().getId_tipoCom());
      this.complemento =  id;
  }
}

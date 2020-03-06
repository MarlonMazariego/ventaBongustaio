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
  public void consultarAll(){
  lista = registroEJB.findAll();
  } 
  
  public void save(){
  
  registroEJB.create(registro);
  }
  
  public void update(){
  
      registroEJB.edit(registro);
  }
  public void delete(RegistrosInicio id){
  registroEJB.delete(id);
  }
  
  public void leerId(RegistrosInicio id){
  this.registro =  id;
  }
}

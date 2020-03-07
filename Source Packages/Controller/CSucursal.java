
package controller;

import ejb.SucursalFacadeLocal;
import entity.Sucursal;
import entity.TipoSucursal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "CSucursal")
@SessionScoped
public class CSucursal implements Serializable{
    
    @EJB
    private SucursalFacadeLocal sucEJB;
    private Sucursal suc;
    private List<Sucursal> lista;
    private TipoSucursal tipSuc;
    String mensa = "";
    
    public List<Sucursal> getLista(){
    lista = sucEJB.findAll();
    return lista;
    }
    public void setLista(List<Sucursal> lista){
    this.lista = lista;
    }

    public Sucursal getSuc() {
        return suc;
    }

    public void setSuc(Sucursal suc) {
        this.suc = suc;
    }

    public TipoSucursal getTipSuc() {
        return tipSuc;
    }

    public void setTipSuc(TipoSucursal tipSuc) {
        this.tipSuc = tipSuc;
    }
    
    @PostConstruct
    public void init(){
    suc = new Sucursal();
    tipSuc = new TipoSucursal();
    }
    
    public void create(){
        FacesMessage message;
        try {
            suc.setId_tipoSucursal(tipSuc);
            sucEJB.create(suc);
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
            suc.setId_tipoSucursal(tipSuc);
            sucEJB.edit(suc);
            init();
            message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Exito","Datos Modificados");
        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Error al Modificar");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public void delete(Sucursal suc){
    FacesMessage message;
        try {
            sucEJB.delete(suc);
            init();
           message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Exito","Datos Eliminados"); 
        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Error al Eliminar");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public void find(Sucursal id){
        try {
            suc = sucEJB.find(id.getId_sucursal());
            tipSuc.setId_tipoSucursal(suc.getId_tipoSucursal().getId_tipoSucursal());
            sucEJB.find(suc.getId_sucursal());
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error",e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}

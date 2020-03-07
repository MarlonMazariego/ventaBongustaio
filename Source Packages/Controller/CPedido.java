
package Controller;

import entity.Pedido;
import entity.Producto;
import entity.Sucursal;
import entity.Usuario;
import ejb.PedidoFacadeLocal;
import entity.Proveedor;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;



@Named(value = "cPedido")
@SessionScoped
public class CPedido implements Serializable{

 @EJB
private PedidoFacadeLocal pedidoEJB;
private Pedido ped;
private List<Pedido> lista;
private Proveedor prov;
private Producto prod;
private Sucursal suc;
private Usuario usu;
private String msj;


//getter ands setter

    public Pedido getPed() {
        return ped;
    }

    public void setPed(Pedido ped) {
        this.ped = ped;
    }

    public List<Pedido> getLista() {
        this.lista = this.pedidoEJB.findAll();
        return lista;
    }

    public void setLista(List<Pedido> lista) {
        this.lista = lista;
    }

    public Proveedor getProv() {
        return prov;
    }

    public void setProv(Proveedor prov) {
        this.prov = prov;
    }

    public Producto getProd() {
        return prod;
    }

    public void setProd(Producto prod) {
        this.prod = prod;
    }

    public Sucursal getSuc() {
        return suc;
    }

    public void setSuc(Sucursal suc) {
        this.suc = suc;
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    @PostConstruct
    public void init(){
        ped = new Pedido();
        prov = new Proveedor();
        prod = new Producto();
        usu = new Usuario();              
    }
    //Método para limpiar
    public void clear(){
        try {
              ped = new Pedido();
        prov = new Proveedor();
        prod = new Producto();
        usu = new Usuario();   
        } catch (Exception e) {
        }
    }
    //Método para guardar
    public  void save(){
        FacesMessage mensa;
        try {
            ped.setId_proveedor(prov);
            this.ped.setId_producto(prod);
            this.ped.setId_sucursal(suc);
            this.ped.setId_usuario(usu);
            pedidoEJB.create(ped);
            msj = "Datos guardados correctamente";
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", msj);
            clear();
        } catch (Exception e) {
            msj = "Error al guardar " +e.getMessage();
            System.out.println("No guarda por " +e.getMessage());
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msj);
        }
        FacesContext.getCurrentInstance().addMessage(msj, mensa);
    }
    //Método para eliminar
    public  void delete(Pedido id){
        FacesMessage mensa;
        try {
            this.pedidoEJB.delete(id);
              msj = "Datos eliminados correctamente";
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", msj);
        } catch (Exception e) {
            msj = "Error al eliminar por " +e.getMessage();
            System.out.println("No elimina por " +e.getMessage());
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msj);
        }
        FacesContext.getCurrentInstance().addMessage(msj, mensa);
    }
    //Método para actualizar
    public  void actualizar(){
        FacesMessage mensa;
        try {       
             this.ped.setId_proveedor(prov);
            this.ped.setId_producto(prod);
            this.ped.setId_sucursal(suc);
            this.ped.setId_usuario(usu);
            pedidoEJB.edit(ped);
            msj = "Datos actualizados correctamente";
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", msj);
            clear();
        } catch (Exception e) {
            msj = "Error al actualizar por " +e.getMessage();
            System.out.println("No actualiza por " +e.getMessage());
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msj);
        }
        FacesContext.getCurrentInstance().addMessage(msj, mensa);
    }
    //Método para cargar
    public void find(Pedido id){
        try {
            this.prov.setId_proveedor(id.getId_proveedor().getId_proveedor());
            this.prod.setId_producto(id.getId_producto().getId_producto());
            this.suc.setId_sucursal(id.getId_sucursal().getId_sucursal());
            this.usu.setId_usuario(id.getId_usuario().getId_usuario());
            this.ped = id;
        } catch (Exception e) {
            System.out.println("No carga por " +e.getMessage());
        }
    }
}

package Controller;

import ejb.DetalleProductoFacadeLocal;
import entity.DetalleProducto;
import entity.Producto;
import entity.Proveedor;
import entity.Sucursal;
import entity.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "cDetalleProducto")
@SessionScoped
public class CDetalleProducto implements Serializable {
    
    @EJB
    private DetalleProductoFacadeLocal detProdEJB;
    private DetalleProducto detProd;
    private List<DetalleProducto> lista;
    //Foráneas
    private Proveedor proveedor;
    private Producto producto;
    private Sucursal sucursal;
    private Usuario usuario;
    private String msj;

    //Getter and setter
    public DetalleProductoFacadeLocal getDetProdEJB() {
        return detProdEJB;
    }
    
    public void setDetProdEJB(DetalleProductoFacadeLocal detProdEJB) {
        this.detProdEJB = detProdEJB;
    }
    
    public DetalleProducto getDetProd() {
        return detProd;
    }
    
    public void setDetProd(DetalleProducto detProd) {
        this.detProd = detProd;
    }
    
    public List<DetalleProducto> getLista() {
        this.lista = this.detProdEJB.findAll();
        return lista;
    }
    
    public void setLista(List<DetalleProducto> lista) {
        this.lista = lista;
    }
    
    public Proveedor getProveedor() {
        return proveedor;
    }
    
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    public Producto getProducto() {
        return producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public Sucursal getSucursal() {
        return sucursal;
    }
    
    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    //Mismo método para limpiar
    @PostConstruct
    public void clear() {
        detProd = new DetalleProducto();
        proveedor = new Proveedor();
        producto = new Producto();
        sucursal = new Sucursal();
        usuario = new Usuario();
    }

    //Método para guardar
    public void save() {
        FacesMessage mensa;
        try {
            this.detProd.setId_proveedor(proveedor);
            this.detProd.setId_producto(producto);
            this.detProd.setId_sucursal(sucursal);
            this.detProd.setId_usuario(usuario);
            detProdEJB.create(detProd);
            msj = "Datos guardados correctamente";
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", msj);
            clear();
        } catch (Exception e) {
            msj = "Error al guardar por " + e.getMessage();
            System.out.println("No guarda por " + e.getMessage());
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msj);
        }
        FacesContext.getCurrentInstance().addMessage(msj, mensa);
    }

    //Método para eliminar
    public void delete(DetalleProducto id) {
        FacesMessage mensa;
        try {
            this.detProdEJB.delete(id);
            msj = "Datos eliminados correctamente";
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", msj);
        } catch (Exception e) {
            msj = "Error al eliminar por " + e.getMessage();
            System.out.println("No elimina por " + e.getMessage());
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msj);
        }
        FacesContext.getCurrentInstance().addMessage(msj, mensa);
    }

    //Método para actualizar
    public void update() {
        FacesMessage mensa;
        try {
            this.detProd.setId_proveedor(proveedor);
            this.detProd.setId_producto(producto);
            this.detProd.setId_sucursal(sucursal);
            this.detProd.setId_usuario(usuario);
            detProdEJB.edit(detProd);
            msj = "Datos actualizados correctamente";
            mensa = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado", msj);
            clear();
        } catch (Exception e) {
            msj = "Error al actualizar por " + e.getMessage();
            System.out.println("No actualiza por " + e.getMessage());
            mensa = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msj);
        }
        FacesContext.getCurrentInstance().addMessage(msj, mensa);
    }

    //Método para cargar
    public void find(DetalleProducto id) {
        try {
            this.proveedor.setId_proveedor(id.getId_proveedor().getId_proveedor());
            this.producto.setId_producto(id.getId_producto().getId_producto());
            this.sucursal.setId_sucursal(id.getId_sucursal().getId_sucursal());
            this.usuario.setId_usuaro(id.getId_usuario().getId_usuaro());
            //Igualamos el parámetro a la entidad
            this.detProd = id;
        } catch (Exception e) {
            System.out.println("No carga por " +e.getMessage());
        }
    }
}

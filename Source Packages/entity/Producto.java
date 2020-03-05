package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbProducto")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_producto;

    @Column(name = "nombre_producto")
    private String nombre_prodcuto;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "unidad_medida")
    private String unidad_medida;
    
    @Column(name = "stock_min")
    private int stock_min;
    
    @Column(name = "stock_max")
    private int stock_max;
    
    @Column(name = "existencias")
    private int existencias;
    
    @Column(name = "costo_unitario")
    private int costo_unitario;
    
    @Column(name = "estado")
    private String estado;
    
    @JoinColumn(name = "id_subCategoria", referencedColumnName = "id_subCategoria")
    @ManyToOne
    private ScaPlatillo id_sibCategoria;

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_prodcuto() {
        return nombre_prodcuto;
    }

    public void setNombre_prodcuto(String nombre_prodcuto) {
        this.nombre_prodcuto = nombre_prodcuto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public int getStock_min() {
        return stock_min;
    }

    public void setStock_min(int stock_min) {
        this.stock_min = stock_min;
    }

    public int getStock_max() {
        return stock_max;
    }

    public void setStock_max(int stock_max) {
        this.stock_max = stock_max;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public int getCosto_unitario() {
        return costo_unitario;
    }

    public void setCosto_unitario(int costo_unitario) {
        this.costo_unitario = costo_unitario;
    }

    public ScaPlatillo getId_sibCategoria() {
        return id_sibCategoria;
    }

    public void setId_sibCategoria(ScaPlatillo id_sibCategoria) {
        this.id_sibCategoria = id_sibCategoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id_producto;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (this.id_producto != other.id_producto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Producto{" + "id_producto=" + id_producto + '}';
    }
    
    
    
    
}

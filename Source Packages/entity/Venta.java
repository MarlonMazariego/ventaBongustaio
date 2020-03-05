/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author marlon.mazariegousam
 */
@Entity
@Table(name = "tbVenta")
public class Venta implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_venta;
    
    @Column(name = "nombre_cliente")
    private String nombre_cliente;
    
    
    @Column(name = "dui_carnet")
    private String dui_carnet;
    
    @Column(name = "nit")
    private String nit;
    
    @Column(name = "dir")
    private String dir;
    
    @Column(name = "tel")
    private String tel;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario",referencedColumnName = "id_usuario")
    private Usuario id_usuario;
    
    @Column(name = "tipo_pago")
    private String tipo_pago;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_hora")
    private Date fecha_hora;
    
    @Column(name = "venta_total")
    private Double venta_total;

    public Venta() {
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getDui_carnet() {
        return dui_carnet;
    }

    public void setDui_carnet(String dui_carnet) {
        this.dui_carnet = dui_carnet;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public Double getVenta_total() {
        return venta_total;
    }

    public void setVenta_total(Double venta_total) {
        this.venta_total = venta_total;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.id_venta;
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
        final Venta other = (Venta) obj;
        if (this.id_venta != other.id_venta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venta{" + "id_venta=" + id_venta + '}';
    }
        
    
}

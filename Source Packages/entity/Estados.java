/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbEstados")
public class Estados implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_estado;

    @Column(name = "ventas")
    private double ventas;
    @Column(name = "inv_inicial")
    private double inv_inicial;
    @Column(name = "compras")
    private double compras;
    @Column(name = "gst_compras")
    private double gst_compras;
    @Column(name = "dev_compras")
    private double dev_compras;
    @Column(name = "inv_final")
    private double inv_final;
    @Column(name = "g_ventas")
    private double g_ventas;
    @Column(name = "g_adm")
    private double g_adm;
    @Column(name = "g_financ")
    private double g_financ;
    @Column(name = "isr")
    private double isr;
    @Column(name = "reserva")
    private double reserva;
    @Column(name = "utilidad", nullable = false)
    private double utilidad;
    @Temporal(TemporalType.DATE)
    @Column(name = "inicio", nullable = false)
    private Date inicio;
    @Temporal(TemporalType.DATE)
    @Column(name = "cierre", nullable = false)
    private Date cierre;
    @Column(name = "comentario", length = 200)
    private String comentario;

    //GET Y SET
    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public double getVentas() {
        return ventas;
    }

    public void setVentas(double ventas) {
        this.ventas = ventas;
    }

    public double getInv_inicial() {
        return inv_inicial;
    }

    public void setInv_inicial(double inv_inicial) {
        this.inv_inicial = inv_inicial;
    }

    public double getCompras() {
        return compras;
    }

    public void setCompras(double compras) {
        this.compras = compras;
    }

    public double getGst_compras() {
        return gst_compras;
    }

    public void setGst_compras(double gst_compras) {
        this.gst_compras = gst_compras;
    }

    public double getDev_compras() {
        return dev_compras;
    }

    public void setDev_compras(double dev_compras) {
        this.dev_compras = dev_compras;
    }

    public double getInv_final() {
        return inv_final;
    }

    public void setInv_final(double inv_final) {
        this.inv_final = inv_final;
    }

    public double getG_ventas() {
        return g_ventas;
    }

    public void setG_ventas(double g_ventas) {
        this.g_ventas = g_ventas;
    }

    public double getG_adm() {
        return g_adm;
    }

    public void setG_adm(double g_adm) {
        this.g_adm = g_adm;
    }

    public double getG_financ() {
        return g_financ;
    }

    public void setG_financ(double g_financ) {
        this.g_financ = g_financ;
    }

    public double getIsr() {
        return isr;
    }

    public void setIsr(double isr) {
        this.isr = isr;
    }

    public double getReserva() {
        return reserva;
    }

    public void setReserva(double reserva) {
        this.reserva = reserva;
    }

    public double getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(double utilidad) {
        this.utilidad = utilidad;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getCierre() {
        return cierre;
    }

    public void setCierre(Date cierre) {
        this.cierre = cierre;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id_estado;
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
        final Estados other = (Estados) obj;
        if (this.id_estado != other.id_estado) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estados{" + "id_estado=" + id_estado + '}';
    }

    public Estados() {
    }

}

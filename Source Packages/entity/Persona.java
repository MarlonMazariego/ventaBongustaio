/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbPersona")
public class Persona implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_persona;
    
    @Column(name="nombres")
    private String nombres;
    
    @Column(name="apellidos")
    private String apellidos;
    
    @Column(name="dui")
    private String dui;
    
    @Column(name="nit")
    private String nit;
    
    @Column(name="edad")
    private int edad;
    
    @Column(name="tel")
    private String tel;
    
    @Column(name="dir")
    private String dir;
    
    @Column(name="email")
    private String email;
    
    @Column(name="genero")
    private int genero;
    
    @Column(name="salario_asignado")
    private double salario_asignado;
    
    @JoinColumn(name="id_cargo", referencedColumnName = "id")
    @ManyToOne
    private Cargo id_cargo;
    
    @JoinColumn(name="id_sucursal" ,referencedColumnName = "id")
    @ManyToOne
    private Sucursal id_sucursal;

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public double getSalario_asignado() {
        return salario_asignado;
    }

    public void setSalario_asignado(double salario_asignado) {
        this.salario_asignado = salario_asignado;
    }

    public Cargo getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(Cargo id_cargo) {
        this.id_cargo = id_cargo;
    }

    public Sucursal getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(Sucursal id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    @Override
    public String toString() {
        return "Persona{" + "id_persona=" + id_persona + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.id_persona;
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
        final Persona other = (Persona) obj;
        if (this.id_persona != other.id_persona) {
            return false;
        }
        return true;
    }
    
    
    
}

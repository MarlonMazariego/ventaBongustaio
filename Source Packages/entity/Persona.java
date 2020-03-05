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
    
}

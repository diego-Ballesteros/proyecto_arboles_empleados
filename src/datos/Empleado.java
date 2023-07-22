/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

/**
 *
 * @author diego
 */
public class Empleado {
    private String nombre;
    private int codigo;
    private float salario;
    private String cargo;
   

    public Empleado(String nombre, int codigo, float salario, String cargo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.salario = salario;
        this.cargo = cargo;
       
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", codigo=" + codigo + ", salario=" + salario + ", cargo=" + cargo + '}';
    }
    

    

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public float getSalario() {
        return salario;
    }

    public String getCargo() {
        return cargo;
    }
    
    
}

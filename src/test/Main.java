/*
 Problema:  Se desea guardar un conjunto de Empleados en un árbol binario de búsqueda y resolver los siguientes requerimientos:
•	Insertar Empleado
•	mostrar empleados ordenados por codigo
•	regitrar horas y precio por hora por empleado registrado
•	Hallar su salario en base a la informacion anterior
       para el salario para cada empleado se le resta el 8%
 */
package test;

import datos.ArbolEmpleados;
import datos.Empleado;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author diego ballesteros
 */
public class Main {
    public static void main(String[] args) {
        
       ArbolEmpleados arbolEmpleados=new ArbolEmpleados();
       ArrayList<Empleado> empleados = new ArrayList<>();
       Scanner entrada = new Scanner(System.in);
       
        String men= "\n1.Agregar Empleado manualmente "
                    + "\n2. Agregar Empeados predeterminados "
                    + "\n3.Mostrar Empleados en orden por codigo "
                    + "\n4.ingresar horas y valor de hora para calcular salarios "
                    + "\n0. Salir"
                    + "\n Elija su opcion --> ";
  
        fin: do {    
        
        System.out.println(men);
        int op = entrada.nextInt();
       
        switch (op) {
            case 1:
                System.out.println("\n  || Agregando Empleado || \n digite los siguientes datos: \n");
                System.out.print(" Digite el codigo: ");
                int codigo = entrada.nextInt();
                System.out.print(" Digite el Nombre: ");
                String nombre = entrada.next();
                System.out.print("Digite el salario: ");
                float salario = entrada.nextFloat();
                System.out.print("Digite el cargo: ");
                String cargo = entrada.next();
                
                Empleado empleado = new Empleado(nombre, codigo, salario, cargo);
                
                arbolEmpleados.insertar(empleado);
                addEmpleado(empleados, empleado);
                
                System.out.println("\n Empleado agregado con exito! ");
                break;

            case 2:
                //istanciando empleados
                Empleado e1 = new Empleado("yuli", 1, 700000, "empleado");
                Empleado e2 = new Empleado("juan", 2, 800000, "empleado");
                Empleado e3 = new Empleado("ceci", 3, 900000, "empleado");

                //insertando empleado
                arbolEmpleados.insertar(e1);
                arbolEmpleados.insertar(e2);
                arbolEmpleados.insertar(e3);
                
                 addEmpleado(empleados, e1,e2,e3);
                break;              
            case 3:
                   System.out.println("Mostrando Empleados ordenados por codigo");
                   arbolEmpleados.inorden(arbolEmpleados.getRaiz());    
                break;
            case 4:
                 int horasTrabajadas;
                float  pagoPorHora;

                 for (Empleado e : empleados) {
                     System.out.println("\n Empleado "+ e.getNombre());
                     System.out.print(" Registre las horas trabajadas: ");
                     horasTrabajadas = entrada.nextInt();
                     System.out.print(" Registre precio por hora ");
                     pagoPorHora = entrada.nextFloat();
                     float salarioNeto = arbolEmpleados.calcularSalarioNeto(e, pagoPorHora, horasTrabajadas);
                     System.out.println("-> El salario neto de el empleado "+e.getNombre()+" es: "+ salarioNeto);
                 }
                break;
            case 0:
                System.out.println("|| Gracias por usar el programa ||");
                break fin;
            default:
               throw new AssertionError();
           }
         } while (true);
    }   
    
    public static void addEmpleado( ArrayList<Empleado> empleados, Empleado ... empleadosadd){
        for(Empleado e : empleadosadd) {
            empleados.add(e);
        }
    }
}

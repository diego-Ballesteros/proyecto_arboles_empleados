/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author Diego ballesteros
 */
public class ArbolEmpleados {
   
    
    private Arbin<Empleado> raiz;
    
    //insertar Empleado
    public void insertar(Empleado x){
        if(getRaiz()==null){
            raiz = new ArbolEnl<>(x);
        }else{
            insertar(getRaiz(),x);
        }
    }
    
   private void insertar(Arbin<Empleado> raiz, Empleado x) {
        if(x.getCodigo()<raiz.obtener().getCodigo()){
            if(raiz.izq()==null){
                raiz.enlIzq(new ArbolEnl<>(x));
            }else
                insertar(raiz.izq(), x);
        }else
            if(raiz.der()==null){
                raiz.enlDer(new ArbolEnl<>(x));
            }else
                insertar(raiz.der(), x);
    }
   
   
   // buscar salario por codigo 
 
    public float consultarSalario ( int codigo){
        if(raiz!=null){
            return consultarSalario(raiz, codigo);
        }else{
            return 0;
        }
    }

    private float consultarSalario(Arbin<Empleado> r, int codigo) {
        Empleado empleado ;
        if(r.obtener().getCodigo()== codigo){
        empleado = r.obtener();
        return r.obtener().getSalario();
        }else{
            if(codigo <r.obtener().getCodigo()){
                if(r.izq()==null)
                    return 0;
                else
                    return consultarSalario(r.izq(), codigo);
            }else{
                if(r.der()==null)
                    return 0;
                else
                    return consultarSalario(r.der(), codigo);
            }
        }
    }
   
   // eliminar empleado por nombre

    public void buscarPorNombreEliminar(Arbin<Empleado> r, String nombre){
        if(r.obtener().getNombre().equalsIgnoreCase(nombre)){
            eliminar(r.obtener().getCodigo());
        }
    }
    
    // eliminar 
    public Arbin<Empleado> mayor (Arbin<Empleado> r){
        if(r.der()==null)
            return r;
        else
            return mayor(r.der());
    }
    
    public void eliminar(int x){
        if(consultarSalario(x)!= 0){
            raiz=eliminar(raiz, x);
        }
    }
    public Arbin<Empleado> eliminar(Arbin<Empleado> r, int x) {
         if(r.obtener().getCodigo()==x){
           return  borrar(r,x);
         }else{
             if(x<r.obtener().getCodigo()){
                 r.enlIzq(eliminar(r.izq(), x));
             }else{
                 r.enlDer(eliminar(r.der(), x));
             }
             return r;
         }    
    }
    public Arbin<Empleado> borrar(Arbin<Empleado> r, int x) {
        if(r.izq()==null && r.der()==null){
            return null;
        }else{
            if(r.izq()==null){
                return r.der();
            }else{
                if(r.der()==null){
                    return r.izq();
                }else{
                    Arbin<Empleado> may = mayor(r.izq());
                    r.cambiar(may.obtener());
                    r.enlIzq(eliminar(r.izq(), may.obtener().getCodigo()));
                    return r;
                }
            }
               
        }
    }
    
   //listar empleados de un cargo
     
   public void listarEmpleadosDeUnCargo(Arbin<Empleado> raiz, String cargo){
       if(raiz!=null){
           hallarEmpleado(raiz,cargo);
           listarEmpleadosDeUnCargo(raiz.izq(), cargo);
           listarEmpleadosDeUnCargo(raiz.der(), cargo);
       }
      
   }
    private void hallarEmpleado(Arbin<Empleado> raiz, String cargo) {
        if(raiz.obtener().getCargo().equalsIgnoreCase(cargo)){
            System.out.println(" "+raiz.obtener().toString());
        }  
    }
   
   public void inorden(Arbin<Empleado> r){
       if(r!=null){
           inorden(r.izq());
           System.out.println(" "+r.obtener().toString());
           inorden(r.der());
       }
   }

   /**
     * @return the raiz
     */
    public Arbin<Empleado> getRaiz(){
        return raiz;
    }
    
    
   public float calcularSalarioNeto(Empleado empleado, float precioPorHora, int horasTrabajadas){
     return (float) ((horasTrabajadas*precioPorHora) - ((horasTrabajadas*precioPorHora)*(0.08)));
   }  
}

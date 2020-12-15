/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fecha;

import utilidades.Utilidad;

/**
 *
 * @author ADMINMJ
 */
public class Principal {
    public static void main(String [] args){
        String fecha;
        Fecha f=new Fecha();
        boolean resultado;
        fecha=Utilidad.pedirString("Introduce una fecha con el formato dd/mm/aaa");
        resultado=f.comprobarFecha(fecha);
        while (!resultado){
            System.out.println("Fecha incorrecta");
             fecha=Utilidad.pedirString("Introduce una fecha con el formato dd/mm/aaa");
            resultado=f.comprobarFecha(fecha);
        }
        System.out.println("El número de días transcurridos es:"
                +f.calcularOrden());
        System.out.println("Fin");
        
        
    }
    
}

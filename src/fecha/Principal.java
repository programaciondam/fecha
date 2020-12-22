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
        Fecha fhoy=new Fecha();
        Fecha f=new Fecha();
        System.out.println(f.fechaEnLetra());
        
        
        f=Utilidad.pedirFecha("Introduce una fecha");
        while(fhoy.compararFechas(f)==-1)
        {
            System.out.println("Fecha incorrecta");
              f=Utilidad.pedirFecha("Introduce una fecha");
        }
        
        
        System.out.println("El número de días transcurridos es:"
                +f.calcularOrden());
        System.out.println("Fin");
        
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservas;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Reservas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Aula a01 = new Aula("A.01", "aulario norte", 165);
        a01.anadir_dia_examen(LocalDate.of(2019, 1, 10), LocalDate.of(2019, 1, 11));
        
        SalaReunion sala1 = new SalaReunion("201", "facultad informatica", 12);
        SalaReunion sala2 = new SalaReunion("202", "facultad informatica", 12);
        SalaReunion sala3 = new SalaReunion("203", "facultad informatica");
        
        ArrayList<Espacio> espacios = new ArrayList<Espacio>();
        espacios.add(a01);
        espacios.add(sala1);
        espacios.add(sala2);
        espacios.add(sala3);
        
        for(Espacio espacio : espacios){
            System.out.println(espacio.toString());
        }
        
        System.out.println("------------------------------------------------------");
        
        for(Espacio espacio : espacios){
            System.out.println(espacio.toString());
            
            if(espacio.reservar("juan@um.es", LocalDate.of(2019, 1, 9), Tramo.TARDE) != null){
                espacio.reservar("juan@um.es", LocalDate.of(2019, 1, 9), Tramo.TARDE).toString();
            }
            if(espacio.reservar("pepe@um.es", LocalDate.of(2019, 1, 9), Tramo.TARDE) != null){
                espacio.reservar("pepe@um.es", LocalDate.of(2019, 1, 9), Tramo.TARDE).toString();
            }
            if(espacio.reservar("pepe@um.es", LocalDate.of(2019, 1, 9), Tramo.MAÑANA) != null){
                espacio.reservar("pepe@um.es", LocalDate.of(2019, 1, 9), Tramo.MAÑANA).toString();
            }
        }
         System.out.println("------------------------------------------------------");
        
        for(Espacio espacio : espacios){
            System.out.println(espacio.toString());
        }
        
        
        
    }
    
}

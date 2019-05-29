/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservas;

import java.time.DayOfWeek;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class Aula extends Espacio{
    ArrayList<LocalDate> dia_de_examenes;

    public Aula(String nombre, String ubicacion, int capacidad) {
        super(nombre, ubicacion, capacidad);
        this.dia_de_examenes = new ArrayList<LocalDate>();
    }
    
    public void anadir_dia_examen(LocalDate ... dias){
        for(LocalDate dia : dias){
            this.dia_de_examenes.add(dia);
        }
    }
    
    protected Reserva reservar(String usuario, LocalDate fecha, Tramo tramo){
        Reserva retorno = null;
        boolean disponible = true;
        for(LocalDate dia : this.dia_de_examenes){
            if(fecha.isEqual(dia)){
                disponible = false;
            }
        }
        
        if(disponible){
            retorno = new Reserva(usuario, this, new Ocupacion(fecha, tramo));
            this.reservas.add(retorno);
        }
            
        
        return retorno;
    }
    

    public ArrayList<LocalDate> getDia_de_examenes() {
        return dia_de_examenes;
    }
    
    
    
    
    
}

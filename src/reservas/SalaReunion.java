/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservas;

import java.time.DayOfWeek;
import static java.time.DayOfWeek.*;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class SalaReunion extends Espacio {
    
    private HashMap<String, ArrayList<Reserva>> usuario_reservas;

    public SalaReunion(String nombre, String ubicacion, int capacidad) {
        super(nombre, ubicacion, capacidad);
        this.usuario_reservas = new HashMap<String, ArrayList<Reserva>>();
    }

    public SalaReunion(String nombre, String ubicacion) {
        super(nombre, ubicacion);
        this.usuario_reservas = new HashMap<String, ArrayList<Reserva>>();
    }
    
    protected Reserva reservar(String usuario, LocalDate fecha, Tramo tramo){
        Reserva retorno = null;
        boolean disponible = true;
        if(!this.consultar(fecha, tramo)){
            if((DayOfWeek.of(fecha.get(ChronoField.DAY_OF_WEEK)) == SATURDAY) && (DayOfWeek.of(fecha.get(ChronoField.DAY_OF_WEEK)) == SUNDAY)){
                ArrayList<Reserva> reservas_usuario = this.consultar_reservas_usuario(usuario);
                if(reservas_usuario != null){
                    for(Reserva reserva : reservas_usuario){
                        if(reserva.getOcupacion().getDia().isEqual(fecha) || reserva.getOcupacion().getDia().isAfter(fecha)){
                            disponible = false;
                        }
                    }
                }
            }
        }
        if(disponible){
            retorno = new Reserva(usuario, this, new Ocupacion(fecha, tramo));
            this.reservas.add(retorno);
            for(Map.Entry<String, ArrayList<Reserva>> e : this.usuario_reservas.entrySet()){
                if(e.getKey() == usuario){
                    e.getValue().add(retorno);
                }
            }
        }
        
        return retorno;
    }
    
    public ArrayList<Reserva> consultar_reservas_usuario(String usuario){
        ArrayList<Reserva> retorno = null;
        for(Map.Entry<String, ArrayList<Reserva>> e: this.usuario_reservas.entrySet()){
            if(e.getKey() == usuario){
                retorno = e.getValue();
            }
        }
        return retorno;
    }
    
    

    
}

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
public abstract class Espacio {
    protected String nombre;
    protected String ubicacion;
    protected String descripcion = nombre + " - " + ubicacion;
    protected int capacidad;
    protected ArrayList<Reserva> reservas;

    public Espacio(String nombre, String ubicacion, int capacidad) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.reservas = new ArrayList<Reserva>();
    }

    public Espacio(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidad = 30;
        this.reservas = new ArrayList<Reserva>();
    }
    
    public boolean consultar(LocalDate fecha, Tramo tramo){
        boolean retorno = true;
        for(Reserva reserva : this.reservas){
            if(reserva.getOcupacion().equals(new Ocupacion(fecha,tramo))){
                retorno = false;
            }
        }
        return retorno;
    }
    
    protected abstract Reserva reservar(String usuario, LocalDate fecha, Tramo tramo);
    //protected abstract Reserva reservar(String usuario);
    
    public boolean cancelar_reserva(Reserva cancelada){
        Reserva eliminar = null;
        for(Reserva reserva : this.reservas){
            if(reserva.equals(cancelada)){
                eliminar = reserva;
            }
        }
        
        if(eliminar != null){
            this.reservas.remove(eliminar);
            return true;
        }else{
            return false;
        }
    }
    
    public String toString(){
        return "nombre: " + this.nombre + " ubicacion: " + this.ubicacion + "descripcion: " + 
        this.descripcion + "capacidad: " + this.capacidad;
    }
    
    
    
}

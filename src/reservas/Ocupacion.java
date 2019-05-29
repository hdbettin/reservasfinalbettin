/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservas;

import java.time.LocalDate;

/**
 *
 * @author Usuario
 */
public class Ocupacion {
    private final LocalDate dia;
    private final Tramo tramo;

    public Ocupacion(LocalDate dia, Tramo tramo) {
        this.dia = dia;
        this.tramo = tramo;
    }
    
    public boolean equals(Ocupacion ocu){
        if(this.dia.isEqual(ocu.dia) && this.tramo == ocu.tramo){
            return true;
        }else{
            return false;
        }
    }

    public LocalDate getDia() {
        return dia;
    }

    public Tramo getTramo() {
        return tramo;
    }
    
    public String ocupacion(){
        return "dia: " + this.dia + "tramo: " + this.tramo;
    }

    
    
    
}

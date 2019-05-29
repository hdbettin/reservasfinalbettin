/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservas;

/**
 *
 * @author Usuario
 */
public class Reserva {
    private  final String usuario;
    private final Espacio espacio;
    private final Ocupacion ocupacion;

    public Reserva(String usuario, Espacio espacio, Ocupacion ocupacion) {
        this.usuario = usuario;
        this.espacio = espacio;
        this.ocupacion = ocupacion;
    }
    
    public boolean equals( Reserva reserva){
        if((this.usuario ==  reserva.usuario) && (this.espacio == reserva.espacio) && (this.ocupacion == reserva.ocupacion) ){
            return true;
        }else{
            return false;
        }
    }

    public String getUsuario() {
        return usuario;
    }

    public Espacio getEspacio() {
        return espacio;
    }

    public Ocupacion getOcupacion() {
        return ocupacion;
    }
    
    public String toString(){
        return "usuario: " + this.usuario + "espacio: " + this.espacio.toString() + " ";
    }
    
    
}

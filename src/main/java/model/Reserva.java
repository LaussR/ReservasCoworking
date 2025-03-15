/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sofar
 */
public class Reserva {
    private String nombreUsuario;
    private String fecha;
    private String espacio;
    private int duracion;

    public Reserva(String nombreUsuario, String fecha, String espacio, int duracion) {
        this.nombreUsuario = nombreUsuario;
        this.fecha = fecha;
        this.espacio = espacio;
        this.duracion = duracion;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getFecha() {
        return fecha;
    }

    public String getEspacio() {
        return espacio;
    }

    public int getDuracion() {
        return duracion;
    }
    
    
}

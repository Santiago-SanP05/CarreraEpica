/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author camper
 */
public class Participantes {
    
    private String nombre;
    private String cedula;
    private int saldoDisponible;

    public Participantes(String nombre, String cedula, int saldoDisponible) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.saldoDisponible = saldoDisponible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(int saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }
    
    
    
}

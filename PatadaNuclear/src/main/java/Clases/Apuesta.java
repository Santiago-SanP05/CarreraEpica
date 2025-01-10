/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

public class Apuesta {
    
    private int participante;
    private int competencia;
    private int burroApostado;
    private int saldoApostado;

    public Apuesta(int participante, int competencia,int burroApostado,int saldoApostado) {
        this.participante = participante;
        this.competencia = competencia;
        this.burroApostado = burroApostado;
        this.saldoApostado = saldoApostado;
    }

    public int getSaldoApostado() {
        return saldoApostado;
    }

    public void setSaldoApostado(int saldoApostado) {
        this.saldoApostado = saldoApostado;
    }


    public int getBurroApostado() {
        return burroApostado;
    }

    public void setBurroApostado(int burroApostado) {
        this.burroApostado = burroApostado;
    }

    public int getParticipante() {
        return participante;
    }

    public void setParticipante(int participante) {
        this.participante = participante;
    }

    public int getCompetencia() {
        return competencia;
    }

    public void setCompetencia(int competencia) {
        this.competencia = competencia;
    }
    
    
    
}

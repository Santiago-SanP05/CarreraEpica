/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Vista;

import Controladores.ControlRegistro;
import java.sql.SQLException;

/**
 *
 * @author yulam
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        ControlRegistro.registrarDueño("Edgar", "23");
        ControlRegistro.registrarCompetencia("2025-05-05", "La mesa", false, 0);
    }
    
}

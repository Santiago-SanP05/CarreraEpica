package Vista;

import Controladores.ControlApuestas;
import Controladores.ControlBurro;
import Controladores.ControlCompetencias;
import Controladores.ControlDuenio;
import Controladores.ControlParticipantes;
import java.sql.SQLException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Menu {

    public static void MenuPrincipal() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("0.Para salir");
            System.out.println("1.Para registrar un burro");
            System.out.println("2. para registrar un apostador");
            System.out.println("3. para ingresar un nuevo dueño de burro");
            System.out.println("4. Para terminar Competencias y marcar su ganador");
            System.out.println("5. para regisrta una competencia");
            System.out.println("6. para iniciar como participante");
            System.out.println("7. para ingresar como dueño de burros");
            System.out.println("");
            System.out.println("");
            int opc = Integer.parseInt(scanner.nextLine());
            switch (opc) {
                case 0:
                    System.out.println("Saliendo");
                    return;
                case 1:
                    System.out.println("Dame el nombre del burro");
                    String nombre = scanner.nextLine();
                    System.out.println("Dame ahora la edad del caballo");
                    String edad = scanner.nextLine();
                    System.out.println("Por ultimo la raza");
                    String raza = scanner.nextLine();

                    if (nombre.matches("^[a-zA-Z\\s]+$") && edad.matches("\\d+") && raza.matches("^[a-zA-Z\\s]+$")) {
                        System.out.println("Nombre valido");
                    } else {
                        System.out.println("nombre no valido");
                        break;
                    }
                    try {
                        ControlDuenio.listarDuenios();
                        System.out.println("Escribe el id del dueño");
                        int id = Integer.parseInt(scanner.nextLine());
                        ControlBurro.registrarBurro(nombre, edad, raza, id);
                    } catch (Exception e) {
                        System.out.println("Probablemente el usuario no existe" + e);
                    } finally {
                        break;
                    }
//           
                case 2:
                    try {
                    System.out.println("Dame el nombre del apostador");
                    String nombreApostador = scanner.nextLine();
                    System.out.println("Ingrese su documento");
                    String docu = scanner.nextLine();
                    System.out.println("Ingresa la cantidad de dinero que tienes para depositar");
                    int saldo = Integer.parseInt(scanner.nextLine());

                    if (nombreApostador.matches("^[a-zA-Z\\s]+$")) {
                    } else {
                        System.out.println("Nombre no valido");
                    }
                    if (docu.matches("\\d{10}")) {
                    } else {
                        System.out.println("Documento no valido '10 digitos' ");
                    }
                    if (saldo >= 0) {
                    } else {
                        System.out.println("Saldo invalido, numero positivos");
                    }

                    ControlParticipantes.registrarParticipantes(nombreApostador, docu, saldo);
                } catch (Exception e) {
                    System.out.println("Hubo algun error  --" + e);
                } finally {
                    break;
                }
                case 3:
//        ControlDuenio.registrarDuenio("Lear", "30");  
                    try {
                    System.out.println("Dame el nombre del dueño");
                    String nombreDuenio = scanner.nextLine();
                    System.out.println("Dame ahora la edad del dueño");
                    String edadDuenio = scanner.nextLine();

                    if (nombreDuenio.matches("^[a-zA-Z\\s]+$") && edadDuenio.matches("\\d+")) {
                        System.out.println("Nombre valido");
                    } else {
                        System.out.println("nombre no valido");
                        break;
                    }
                    ControlDuenio.registrarDuenio(nombreDuenio, edadDuenio);
                } catch (Exception e) {
                    System.out.println("Error al insertar, O Digitò mal algun valor --" + e);
                }
                case 4:
                    try {
                    ControlCompetencias.listarCompetenciasNoTerminadas();
                    System.out.println("Ingresa el id de la competencia que deseas terminar");
                    int idCompetencia = Integer.parseInt(scanner.nextLine());
                    ControlCompetencias.listarBurrosCompetencia(idCompetencia);
                    System.out.println("elige alguno de los corredores para marcar como ganador de esta carrera");
                    int idGanador = Integer.parseInt(scanner.nextLine());
                    ControlCompetencias.actualizarCompetencia(idGanador, idCompetencia);

                } catch (Exception e) {
                    System.out.println("Hubo un error --" + e);
                } finally {
                    break;
                }
                case 5:
                    try {
                    System.out.println("Porfa ingresa la fecha de inicio de la competencia en formaro yyyy-mm-dd");
                    String fechaCompetencia = scanner.nextLine();
                    System.out.println("Ponle un nombre a la carrera");
                    String nombreCompetencia = scanner.nextLine();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate fechaCompetenciaDate = LocalDate.parse(fechaCompetencia, formatter);

                    if (fechaCompetenciaDate.isBefore(LocalDate.now())) {
                        System.out.println("La fecha ingresada es una fecha pasada. Por favor, ingresa una fecha futura.");
                    } else {
                        System.out.println("Fecha válida: " + fechaCompetenciaDate);
                        break;  // Salir del bucle si la fecha es válida
                    }
                    ControlCompetencias.registrarCompetencia(fechaCompetencia, nombreCompetencia);

                } catch (Exception e) {
                    System.out.println("Hubo algun error  --" + e);
                } finally{break;}
                case 6:
                    try {
                        System.out.println("Escribe tu cedula para ingresar");
                        String doc = scanner.nextLine();
                        
                } catch (Exception e) {
                }

                

                default:
                    System.out.println("Error digite solo los numeros que hay en el menu");
            }
        }
    }
    
    public static void MenuParticipante(){
        Scanner scanner = new Scanner(System.in);
        
        while (true){
            System.out.println("0. para retroceder ");
            System.out.println("1. para hacer una apuesta");
            System.out.println("2. para eliminar el perfil");
//            System.out.println("3. para ver mi saldo");
            int opc = Integer.parseInt(scanner.nextLine());
            switch (opc) {
                case 0:
                    System.out.println("Retrocediendo...");
                    return;
                case 1:
//        ControlApuestas.registrarApuesta(1, 1, 1, 20000);                    
                    try {
                        System.out.println("Ingrese su cedula");
                        String docu = scanner.nextLine();
                        int idParti = ControlParticipantes.RetornarElIdParticipante(docu);
                        ControlCompetencias.listarCompetenciasNoTerminadas();
                        System.out.println("Ingrese a la competencia por su id");
                        int IdCompetencia = Integer.parseInt(scanner.nextLine());
                        ControlCompetencias.listarBurrosCompetencia(IdCompetencia);
                        System.out.println("Elije el burro a apostar");
                        int BurroApostado = Integer.parseInt(scanner.nextLine());
                        System.out.println("Digita la cantidad de dinero piensas apostar");
                        int saldoIngresado = Integer.parseInt(scanner.nextLine());
                        
                        
                        
                        
                        
                } catch (Exception e) {
                }
                    
                default:
                    throw new AssertionError();
            }

        }
    }
    
    

}

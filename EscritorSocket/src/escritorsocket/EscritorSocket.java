/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escritorsocket;

/**
 * * @author
 */
import java.net.*;
import java.io.*;
import java.util.Date;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class EscritorSocket {

    public static void main(String[] args) {
    Logger logger = Logger.getLogger("MiLog");
        FileHandler fh;
        try {
            fh = new FileHandler("./src/escritorsocker/LogEscritor.log");
            SimpleFormatter formatoLog = new SimpleFormatter();
            logger.addHandler(fh);
            logger.setUseParentHandlers(true);
            fh.setFormatter(formatoLog);
            logger.setLevel(Level.ALL);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, String.valueOf(new Date())+" -- Exception del archivo en la entrada y/o salida del mismo.");
        } catch (SecurityException ex) {
            logger.log(Level.SEVERE, String.valueOf(new Date())+" -- Exception en la segurdad del archivo log.");
        }
        
        
        ServerSocket conexion = null; //Creamos un socket para la conexion
        Socket canal = null; //Un canal para el flujo
        PrintStream salStream = null; //Stream de datos (puerta de salida)
        
        //int idConsumidor = Integer.parseInt(args[0]);
        //conexion.isBound() == false; Preguntar como entrar en el bucle
        
        while (conexion.isBound()!=true) {
        try {
            conexion = new ServerSocket(12500);
            System.out.println("Conectó");
        } 
        catch (IOException ex) {
            System.out.println("Error al conectar. Espere...");
            logger.log(Level.SEVERE, String.valueOf(new Date())+" -- Error al conectar.");
            ex.printStackTrace();
            try {
                Thread.sleep(500);
            } 
            catch (InterruptedException ex1) {
                System.out.println("Error :"+ex.toString());
                logger.log(Level.SEVERE, String.valueOf(new Date())+" -- Error :"+ex.toString()+".");
            }
        }
        }
        System.out.println("Pasó");  
    }

}

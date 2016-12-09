/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lanzador;

import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author usuario
 */
public class Lanzador {

    public static void main(String[] args) {
        
        Logger logger = Logger.getLogger("MiLog");
        FileHandler fh;
        try {
            fh = new FileHandler("./src/lanzador/LogLanzador.log");
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
        
        try {
            //Ejecutamos el Productor
            Runtime.getRuntime().exec("java -jar Productor.jar");
            
            //Ejecutamos 100 veces el Consumidor
            for (int i = 0; i<100; i++) {
                Runtime.getRuntime().exec("java -jar Consumidor.jar");
            }
        } 
        catch (IOException ex) {
            //Se imprime el error en la consola (formato por defecto)
            logger.log(Level.SEVERE, String.valueOf(new Date())+" -- Error en la ejecucion.");
            ex.printStackTrace();
        }    

    }
}

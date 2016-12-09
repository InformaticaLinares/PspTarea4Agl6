/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectorsocket;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
/*** @author Marina
 */
public class LectorSocket {

    public static void main(String[] args) throws IOException {
        
        Logger logger = Logger.getLogger("MiLog");
        FileHandler fh;
        try {
            fh = new FileHandler("./src/escritorsocket/LogEscritor.log");
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
        
        Socket canal = null; //Establecemos el canal
        BufferedReader entrada = null; //Establecemos la entrada
        String datosEntrada;
        
        try {
            canal = new Socket("localhost",12500);
            InputStream datos = canal.getInputStream();
            
        } catch (IOException ex) {
            //Establecer archivo log
            logger.log(Level.SEVERE, String.valueOf(new Date())+" -- Error: "+ex.toString()+".");
            ex.printStackTrace();
        }    
    }
    
}

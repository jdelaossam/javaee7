/*
 * Intecap
 * JAVA Learning center
 * .
 */
package co.edu.intecap.lecture.main;

import co.edu.intecap.lecture.network.MyServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author cesar.hoyos@gmail.com
 */
public class Launcher {
    
    /**
     * Launcher Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Launcher.class);

    /**
     * Application main method Starts MyServer Thread
     *
     * @param args
     */
    public static void main(String[] args) {
        
        LOGGER.info("My Server Application starting...");
        
        Thread serverThread = new Thread(new MyServer());
        serverThread.start();
    }
}

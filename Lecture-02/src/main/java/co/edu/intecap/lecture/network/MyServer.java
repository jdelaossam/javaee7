/*
 * Intecap
 * JAVA Learning center
 * .
 */
package co.edu.intecap.lecture.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Server Socket listen in port 9001
 *
 * @author cesar.hoyos@gmail.com
 */
public class MyServer implements Runnable {

    /**
     * The ServerSocket
     */
    private static ServerSocket serverSocket;

    /**
     * MyServer Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MyServer.class);

    /**
     * Constant for MyServer port number
     */
    private static final int SERVER_PORT = 9001;

    /**
     * Static initializer to start Server
     */
    static {
        try {
            serverSocket = new ServerSocket(SERVER_PORT);
            LOGGER.info("Server started in port [{}]", SERVER_PORT);
        } catch (IOException ex) {
            LOGGER.error("The port {} is open", SERVER_PORT);
            System.exit(1);
        }
    }

    /**
     * Infinite accept remote client connections
     *
     */
    @Override
    public void run() {

        while (true) {
            try {
                LOGGER.info("Server ready to accept connections ...");
                Socket client = serverSocket.accept();
                
                ConnectionManager connectionManager = new ConnectionManager(client);

                //TODO Start connectionManager Thread
                //TODO Remove this warning
                LOGGER.warn("Not working if Thread is not started");
                
            } catch (IOException ex) {
                LOGGER.error("Error accepting a remote connection");
            }
        }
        
    }
    
}

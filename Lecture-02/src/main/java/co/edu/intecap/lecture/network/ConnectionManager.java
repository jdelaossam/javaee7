/*
 * Intecap
 * JAVA Learning center
 * .
 */
package co.edu.intecap.lecture.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author cesar.hoyos@gmail.com
 */
public class ConnectionManager extends Thread {

    /**
     * The Socket representing the client
     */
    private final Socket clientConnection;

    /**
     * ConnectionManager Logger
     */
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ConnectionManager.class);
    
    /**
     * End of line Character
     */
    private static final String END_LINE = "\n";

    /**
     * Constructor init clientConnection
     *
     * @param clientConnection
     */
    public ConnectionManager(Socket clientConnection) {
        this.clientConnection = clientConnection;
    }

    /**
     * Process the client request
     */
    @Override
    public void run() {

        try {

            // The read strategy
            InputStream inputStream = clientConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            try (BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

                String thisLine;
                while (!(thisLine = bufferedReader.readLine()).isEmpty()) {
                    System.out.println(thisLine);
                }

                LOGGER.debug("Socket read complete");

                // The write strategy
                OutputStream outputStream = clientConnection.getOutputStream();
                try (PrintWriter out = new PrintWriter(outputStream)) {
                    
                    // TODO call buildResponse() method
                    
                    out.println("Not yet implemented");
                    out.flush();
                }
                LOGGER.debug("Response complete");
            }
            clientConnection.close();
            LOGGER.info("Client connection closed");

        } catch (IOException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Build response resource
     *
     * @return String - The server response
     */
    private String buildResponse() {
        
        String message = "Hi from Lecture 2!";
        
        StringBuilder response = new StringBuilder();
        
        response.append("<html>");
        response.append(END_LINE);
        response.append("   <body>");
        response.append(END_LINE);
        response.append("       <h1>");
        response.append(message);
        response.append("</h1>");
        response.append(END_LINE);
        response.append("   </body>");
        response.append(END_LINE);
        response.append("</html>");
        
        return response.toString();
    }

}

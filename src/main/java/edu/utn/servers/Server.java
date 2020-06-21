package edu.utn.servers;

import edu.utn.clients.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server{

    private ServerSocket server = null;
    private DataInputStream in;
    private DataOutputStream out;

    private final int PORT = 3000;

    public void start(){
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server initialized");
            System.out.println();

            while(true){
                Socket sc = server.accept();
                new ServerThread(sc).start();
                System.out.println("Client connected");
                System.out.println();
            }
        } catch (IOException e) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, "The server has failed", e);
        }
    }
}

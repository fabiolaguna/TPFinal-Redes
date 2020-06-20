package edu.utn.servers;

import edu.utn.clients.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    private ServerSocket server = null;
    private Socket sc = null;
    private DataInputStream in;
    private DataOutputStream out;

    private final int PORT = 3000;

    public synchronized void start(){

        try {
            server = new ServerSocket(PORT);
            System.out.println("Server initialized");
            System.out.println();
            sc = server.accept();
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            String inMessage = "";

            while(true){

                inMessage = in.readUTF();
                System.out.println("Client message: " + inMessage);
                System.out.println();

                String outMessage = "The server has received the message: " + inMessage;
                out.writeUTF(outMessage);
                System.out.println(outMessage);
                System.out.println();

                inMessage = in.readUTF();
                if(inMessage.equalsIgnoreCase("x")){
                    System.out.println("Client disconnected");
                    sc.close();
                }
            }
        } catch (IOException e) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, "The server has failed", e);
        }
    }
}

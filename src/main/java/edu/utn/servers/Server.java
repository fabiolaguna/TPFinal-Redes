package edu.utn.servers;

import edu.utn.clients.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    private ServerSocket server = null;
    private Socket sc = null;
    private DataInputStream in;
    private DataOutputStream out;

    private final int PORT = 3000;


    public void startAll(){
        try {
            server = new ServerSocket(PORT);
            System.out.println("Servidor iniciado");

            while(true){
                sc = server.accept();
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                String message = in.readUTF();

                System.out.println(message);

                out.writeUTF("Hola mundo desde el servidor");

                sc.close();
                System.out.println("Cliente desconectado");
            }
        } catch (IOException e) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}

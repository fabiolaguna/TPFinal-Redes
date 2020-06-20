package edu.utn.clients;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client implements Runnable{

    private final String HOST = "127.0.0.1";
    private final int PORT = 3000;
    private DataInputStream in;
    private DataOutputStream out;
    @Override
    public void run() {
        startAll();
    }

    private void startAll(){
        try {
            Socket sc = new Socket(HOST, PORT);

            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            out.writeUTF("Hola mundo desde el cliente");

            String message = in.readUTF();

            System.out.println(message);

            sc.close();

        } catch (IOException e) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}

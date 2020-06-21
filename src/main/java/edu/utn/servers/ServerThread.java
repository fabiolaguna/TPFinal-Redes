package edu.utn.servers;

import edu.utn.clients.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerThread extends Thread{
    private Socket sc;

    public ServerThread (Socket sc){
        this.sc = sc;
    }

    @Override
    public void run() {
        boolean continueClient = true;
        String inMessage = null;
        String outMessage = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            PrintWriter out = new PrintWriter(sc.getOutputStream(), true);

            while(continueClient){
                inMessage = bufferedReader.readLine();
                outMessage = "The server has received the message: " + inMessage;
                System.out.println(outMessage);
                System.out.println();

                out.println(outMessage);

                inMessage = bufferedReader.readLine();

                if(inMessage.equalsIgnoreCase("x")){
                    System.out.println("Client disconnected");
                    System.out.println();
                    continueClient = false;
                    sc.close();
                }
            }
        } catch (IOException e) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, "The server has failed", e);
        }
    }
}

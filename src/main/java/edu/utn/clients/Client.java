package edu.utn.clients;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client implements Runnable{

    private DataInputStream in;
    private DataOutputStream out;
    private final String EXCEPTION_MESSAGE = "The connection couldn't be done, the port and/or host entered doesn't exist";
    private String HOST = null;
    private int PORT = -1;
    private Socket sc;
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        try {
            start();
        } catch (IOException e) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, EXCEPTION_MESSAGE, e);
        }
        scanner.close();
    }

    private void start() throws IOException{
        boolean clientContinue = true;

        if(HOST == null && PORT == -1)
            createSocket();

        do{
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            System.out.print("Enter the message you want to send: ");
            String outMessage = scanner.next();
            System.out.println();
            out.writeUTF(outMessage);
            System.out.println("Sent message -> " + outMessage);
            System.out.println();

            String inMessage = in.readUTF();
            System.out.println("Server message -> " + inMessage);
            System.out.println();

            System.out.print("Press 'X' to disconnect or another key to continue: ");
            String letter = scanner.next();
            out.writeUTF(letter);
            System.out.println();

            if(letter.equalsIgnoreCase("x")){
                System.out.println("Client disconnected");
                sc.close();
                clientContinue = false;
            }
        } while(clientContinue);
    }

    private void createSocket() throws IOException{
        System.out.print("Enter host: ");
        HOST = scanner.next();
        System.out.println();

        System.out.print("Enter port: ");
        PORT = scanner.nextInt();
        System.out.println();

        this.sc = new Socket(HOST, PORT);

        System.out.println("Connection established");
        System.out.println();
    }
}

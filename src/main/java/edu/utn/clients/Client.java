package edu.utn.clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client{

    private BufferedReader in;
    private PrintWriter out;
    private final String EXCEPTION_MESSAGE = "The connection couldn't be done, the port and/or host entered doesn't exist";
    private String HOST = null;
    private int PORT = -1;
    private Socket sc;
    private final Scanner scanner = new Scanner(System.in);

    public void start(){
        try {
            if(HOST == null && PORT == -1)
                createSocket();

            boolean clientContinue = true;
            out = new PrintWriter(sc.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader inServer = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            String outMessage = "";
            String inMessage = "";
            do{
                System.out.print("Enter the message you want to send: ");
                outMessage = in.readLine();;
                System.out.println();
                out.println(outMessage);

                System.out.println("Sent message -> " + outMessage);
                System.out.println();

                inMessage = inServer.readLine();
                System.out.println("Server message -> " + inMessage);
                System.out.println();

                System.out.print("Press 'X' to disconnect or another key to continue: ");
                outMessage = in.readLine();
                out.println(outMessage);
                System.out.println();

                if(outMessage.equalsIgnoreCase("x")){
                    System.out.println("Client disconnected");
                    clientContinue = false;
                    sc.close();
                }
            } while(clientContinue);
        } catch (IOException e) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, EXCEPTION_MESSAGE, e);
        }

    }

    private void createSocket() throws IOException{
        System.out.print("Enter host: ");
        HOST = scanner.nextLine();
        System.out.println();

        System.out.print("Enter port: ");
        PORT = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        this.sc = new Socket(HOST, PORT);

        System.out.println("Connection established");
        System.out.println();
    }
}

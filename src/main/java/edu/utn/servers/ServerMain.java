package edu.utn.servers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class ServerMain
{
    public static void main( String[] args )
    {
        ServerSocket server = null;
        Socket sc = null;
        final int HOST = 3000;
        DataInputStream inputStream;
        DataOutputStream outputStream;

        try{
            server = new ServerSocket(HOST);
            System.out.println("ServerMain initialized");

            inputStream = new DataInputStream(sc.getInputStream());
            outputStream = new DataOutputStream(sc.getOutputStream());

            while (true){
                sc = server.accept();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}

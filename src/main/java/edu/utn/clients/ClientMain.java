package edu.utn.clients;

public class ClientMain
{
    public static void main( String[] args )
    {
        Thread thread = new Thread(new Client());
        thread.start();
    }
}
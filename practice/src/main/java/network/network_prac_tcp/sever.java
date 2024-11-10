package network.network_prac_tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class sever {
    public static void main(String[] args) throws IOException
    {
        ServerSocket sever = new ServerSocket(25565);



        while(true){
            Socket serverget = sever.accept();
            new mythread(serverget).start();


        }
    }
}
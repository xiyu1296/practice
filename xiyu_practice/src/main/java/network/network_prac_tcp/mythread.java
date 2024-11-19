package network.network_prac_tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class mythread extends Thread{

    private  Socket sc;

    public mythread(Socket sc){

        this.sc = sc;
    }

    public void run(){
        try {
            InputStream is = sc.getInputStream();
            DataInputStream dis = new DataInputStream(is);


            String ip = sc.getInetAddress().getHostAddress();
            String port = String.valueOf(sc.getPort());

            System.out.println(dis.readUTF());
            System.out.println("ip:"+ip);
            System.out.println("port:"+port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
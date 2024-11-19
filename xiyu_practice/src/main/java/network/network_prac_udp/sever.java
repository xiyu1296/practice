package network.network_prac_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class sever {
    public static void main(String[] args) throws IOException {

        DatagramSocket mysever = new DatagramSocket(25565);

        while(true){
            DatagramPacket mypacket = new DatagramPacket(new byte[1024],1024);

            mysever.receive(mypacket);

            System.out.println(new String(mypacket.getData(),0,mypacket.getLength()));

            String client_ip = String.valueOf(mypacket.getAddress());
            String client_port = String.valueOf(mypacket.getPort());

            System.out.println("ip:"+client_ip);
            System.out.println("port:"+client_port);


        }

    }
}
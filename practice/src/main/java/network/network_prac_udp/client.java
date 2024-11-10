package network.network_prac_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws IOException {

        DatagramSocket myclient = new DatagramSocket();

        Scanner sc = new Scanner(System.in);
        while(true){
            if("exit".equals(sc.nextLine())){
                break;
            }

            byte[] content= sc.nextLine().getBytes();

            DatagramPacket mypackege = new DatagramPacket(content,content.length,
                    java.net.InetAddress.getByName("localhost"),25565);

            myclient.send(mypackege);

        }

    }
}
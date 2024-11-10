package network.network_prac_tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws IOException
    {
        Socket client = new Socket("localhost",25565);

        OutputStream cos = client.getOutputStream();
        DataOutputStream dos = new DataOutputStream(cos);

        Scanner sc = new Scanner(System.in);
        while(true){

            String content =  sc.nextLine();

            if("exit".equals(content)){
                dos.close();
                client.close();
                break;
            }

            dos.writeUTF(content);
            dos.flush();

        }
    }
}
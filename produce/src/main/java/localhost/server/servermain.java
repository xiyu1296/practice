package localhost.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class servermain {

    public static final Map<Socket, String> useronlinelist= new HashMap<>();
    public static void main(String[] args){

        try {

            ServerSocket ss = new ServerSocket(8888);

            while(true){
                Socket s = ss.accept();
                new serverthread(s).start();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
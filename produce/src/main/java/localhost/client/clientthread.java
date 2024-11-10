package localhost.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class clientthread extends Thread{
    ClientChatFrame clientChatFrame;
    Socket socket;
    DataInputStream dis;

    public clientthread(ClientChatFrame clientChatFrame, Socket socket) throws IOException {
        this.clientChatFrame = clientChatFrame;
        this.socket = socket;
        this.dis = new DataInputStream(socket.getInputStream());
    }

    public void run(){
        while(true){
            try {
                int num = dis.readInt();
                switch (num){
                    case 1:{
                        updateonlineuserlist();
                    }
                    case 2:{
                        clientChatFrame.showontable();
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }
    }

    private void updateonlineuserlist() throws IOException {
        int count = dis.readInt();
        String[] names = new String[count];

        for (int i = 0; i < count ; i++) {
            names[i] = dis.readUTF();

        }

        clientChatFrame.updateonlinelist(names);


    }

}
package multiproceed.common.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private  Socket client;
    private  ObjectInputStream input;
    private  ObjectOutputStream output;

    public Client() {
        try {
            ConnectToServer();
            GetStreams();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void ConnectToServer() throws UnknownHostException, IOException {
        System.out.println("[INFO] 连接服务器中");
        this.client = new Socket("127.0.0.1", 8888);
        System.out.println("[INFO] 已建立连接: " + client.getInetAddress().getHostName());
    }

    private void GetStreams() throws IOException {
        this.output = new ObjectOutputStream(client.getOutputStream());
        this.output.flush();
        this.input = new ObjectInputStream(client.getInputStream());
        System.out.println("[INFO] IO流构造完成");
    }

    public void CloseConnection() throws IOException {
        output.close();
        input.close();
        client.close();
    }

    public void SendMessage(String message) throws IOException {
        output.writeObject(message);
        output.flush();
    }

    public void ReceiveMessage() throws ClassNotFoundException, IOException {
        String messageFromServer = (String) input.readObject();
        System.out.println("SERVER>>> " + messageFromServer);
    }
}

package multiproceed.common.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private static Socket client;
    private static ObjectInputStream input;
    private static ObjectOutputStream output;

    public static void ConnectToServer() throws UnknownHostException, IOException {
        System.out.println("[INFO] 连接服务器中");
        client = new Socket("127.0.0.1", 8888);
        System.out.println("[INFO] 已建立连接: " + client.getInetAddress().getHostName());
    }

    public static void GetStreams() throws IOException {
        output = new ObjectOutputStream(client.getOutputStream());
        output.flush();
        input = new ObjectInputStream(client.getInputStream());
        System.out.println("[INFO] IO流构造完成");
    }

    public static void CloseConnection() throws IOException {
        output.close();
        input.close();
        client.close();
    }

    public static void SendMessage(String message) throws IOException {
        output.writeObject(message);
        output.flush();
    }

    public static void ReceiveMessage() throws ClassNotFoundException, IOException {
        String messageFromServer = (String) input.readObject();
        System.out.println("SERVER>>> " + messageFromServer);
    }
}

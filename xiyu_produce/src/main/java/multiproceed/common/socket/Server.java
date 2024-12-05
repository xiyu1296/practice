package multiproceed.common.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static ServerSocket server;
    private static ObjectOutputStream output;
    private static ObjectInputStream input;
    private static Socket connection;

    public static void WaitForConnection() throws IOException {
        System.out.println("[INFO] 开始监听连接");
        connection = server.accept();
        System.out.println("[INFO] 已建立连接: " + connection.getInetAddress().getHostName());
    }

    public static void GetStreams() throws IOException {
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input = new ObjectInputStream(connection.getInputStream());
        System.out.println("[INFO] IO流构造完成");
    }

    public static void ProcessConnection() throws IOException, ClassNotFoundException {
        String messageFromClient;
        do {
            messageFromClient = (String) input.readObject();
            System.out.println("CLIENT>>> " + messageFromClient);
            output.writeObject(messageFromClient);
            output.flush();
        } while (!messageFromClient.startsWith("LOGOUT"));
        output.writeObject(messageFromClient);
        output.flush();
    }

    public static void CloseConnection() {
        try {
            output.close();
            input.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            server = new ServerSocket(8888);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            while (true) {
                WaitForConnection();
                GetStreams();
                ProcessConnection();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
    }
}

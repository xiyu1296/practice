package multiproceed.common.socket;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server extends Thread {
    private static ArrayList<ObjectOutputStream> outputToClients;
    private ObjectInputStream input;
    private final Socket connection;
    private static int connectionCounter = 0;
    private final String name;

    public Server(Socket connection, String name) {
        this.connection = connection;
        this.name = name;
        try {
            input = new ObjectInputStream(connection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            String messageFromClient;
            ObjectOutputStream output = new ObjectOutputStream(connection.getOutputStream());
            outputToClients.add(output);
            System.out.println("[INFO] IO流构造完成");
            do {
                messageFromClient = (String) input.readObject();
                System.out.println(this.name + ">>> " + messageFromClient);
                output.writeObject(messageFromClient);
                output.flush();
            } while (!messageFromClient.startsWith("LOGOUT"));
            output.writeObject(messageFromClient);
            output.flush();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8888);
            outputToClients = new ArrayList<ObjectOutputStream>();
            while (true) {
                System.out.println("[INFO] 开始监听连接");
                Socket connection = server.accept();
                connectionCounter++;
                System.out.println("[INFO] 已建立连接 #" + connectionCounter + ": " + connection.getInetAddress().getHostName());
                Thread t = new Server(connection, "CLIENT#" + connectionCounter);
                t.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

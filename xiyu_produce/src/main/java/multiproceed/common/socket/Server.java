package multiproceed.common.socket;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static ArrayList<ObjectOutputStream> outputToClients;
    private static ExecutorService executorService;
    private static int connectionCounter = 0;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8888);
            outputToClients = new ArrayList<ObjectOutputStream>();
            // 创建一个固定大小的线程池
            executorService = Executors.newFixedThreadPool(10);

            while (true) {
                System.out.println("[INFO] 开始监听连接");
                Socket connection = server.accept();
                connectionCounter++;
                System.out.println("[INFO] 已建立连接 #" + connectionCounter + ": " + connection.getInetAddress().getHostName());
                // 提交任务到线程池
                executorService.submit(new ClientHandler(connection, "CLIENT#" + connectionCounter));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
        }
    }

    static class ClientHandler implements Runnable {
        private final Socket connection;
        private final String name;
        private ObjectInputStream input;

        public ClientHandler(Socket connection, String name) {
            this.connection = connection;
            this.name = name;
            try {
                input = new ObjectInputStream(connection.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
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
                e.printStackTrace();
            } finally {
                try {
                    if (input != null) {
                        input.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

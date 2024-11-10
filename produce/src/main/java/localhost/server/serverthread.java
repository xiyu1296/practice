package localhost.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Collection;

public class serverthread extends Thread {
    private Socket socket;
    DataInputStream dis;

    public serverthread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {


        try {
            dis = new DataInputStream(socket.getInputStream());
            /*
             * 接收的消息可能有很多种类型：1、登录消息（包含昵称） 2、群聊消息 3、私聊消息
             * 所以客户端必须声明协议发送消息
             * 比如客户端先发1，代表接下来是登录消息。
             * 比如客户端先发2，代表接下来是群聊消息。
             * 先从socket管道中接收客户端发送来的消息类型编号
             */
            while (true) {
                int flag = dis.readInt();

                switch (flag) {

                    case 1: {
                        // 登录消息
                        String nickname = dis.readUTF();
                        servermain.useronlinelist.put(socket, nickname);
                        updateUserList();

                    }

                    case 2: {
                        // 群聊消息
                        String msg = dis.readUTF();
                        sendtoall(msg);
                    }
                }
            }


        } catch (Exception e) {
            System.out.println(socket.getInetAddress().getHostAddress() + "下线了");
            servermain.useronlinelist.remove(socket);
            updateUserList();
        }

    }

    private void sendtoall(String msg) throws IOException {
        StringBuilder sb = new StringBuilder();
        String name = servermain.useronlinelist.get(socket);

        LocalDateTime ldt =  LocalDateTime.now();

        String putmsg = sb.append("[" + name + "]").append(" ").append(ldt).append("\r\n")
                .append(msg).append("\r\n").toString();


        for(Socket sc : servermain.useronlinelist.keySet()){
            DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
            dos.writeInt(2);
            dos.writeUTF(putmsg);
            dos.flush();
        }
    }

    private void updateUserList() {
        Collection<String> cc = servermain.useronlinelist.values();
        int num = servermain.useronlinelist.size();
        for (Socket tmps : servermain.useronlinelist.keySet()) {

            try {
                DataOutputStream dis2 = new DataOutputStream(tmps.getOutputStream());

                dis2.writeInt(1);
                dis2.writeInt(num);
                for (String nicknnm : cc) {

                    dis2.writeUTF(nicknnm);
                    dis2.flush();

                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
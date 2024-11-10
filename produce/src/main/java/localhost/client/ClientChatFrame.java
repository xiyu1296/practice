package localhost.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * localhost.client.ClientChatFrame 类用于创建客户端聊天窗口
 * 继承自 JFrame，包含消息显示区、输入框、发送按钮和在线用户列表
 */
public class ClientChatFrame extends JFrame {
    // 消息显示区
    public JTextArea smsContent = new JTextArea(23, 50);
    // 消息输入框
    private JTextArea smsSend = new JTextArea(4, 40);
    // 在线用户列表
    public JList<String> onLineUsers = new JList<>();
    // 发送按钮
    private JButton sendBn = new JButton("发送");

    Socket socket;


    /**
     * 构造方法，初始化聊天窗口并使其可见
     */
    public ClientChatFrame() {
        initView();
        this.setVisible(true);
    }

    public ClientChatFrame(Socket socket,String nickname) throws IOException {
        this();
        this.socket = socket;
        this.setTitle(nickname+"的聊天窗口");
        new clientthread(this,socket).start();

    }

    /**
     * 初始化聊天窗口界面布局和组件
     */
    private void initView() {
        // 设置窗口大小、布局、关闭操作和位置
        this.setSize(700, 600);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 关闭窗口，退出程序
        this.setLocationRelativeTo(null); // 窗口居中

        // 设置窗口背景色
        this.getContentPane().setBackground(new Color(0xf0, 0xf0, 0xf0));

        // 定义字体样式
        Font font = new Font("SimKai", Font.PLAIN, 14);

        // 消息内容框配置
        smsContent.setFont(font);
        smsContent.setBackground(new Color(0xdd, 0xdd, 0xdd));
        smsContent.setEditable(false);

        // 发送消息框配置
        smsSend.setFont(font);
        smsSend.setWrapStyleWord(true);
        smsSend.setLineWrap(true);

        // 在线用户列表配置
        onLineUsers.setFont(font);
        onLineUsers.setFixedCellWidth(120);
        onLineUsers.setVisibleRowCount(13);

        // 创建底部面板，包含消息输入框和发送按钮
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(new Color(0xf0, 0xf0, 0xf0));

        // 消息输入框滚动面板

        // 创建一个滚动面板来容纳smsSend组件
        JScrollPane smsSendScrollPane = new JScrollPane(smsSend);
        // 设置滚动面板的边框为空，以去除边框
        smsSendScrollPane.setBorder(BorderFactory.createEmptyBorder());
        // 设置滚动面板的首选尺寸为500x50像素
        smsSendScrollPane.setPreferredSize(new Dimension(500, 50));
        // 发送按钮配置
        sendBn.setFont(font);
        sendBn.setBackground(Color.decode("#009688"));
        sendBn.setForeground(Color.WHITE);

        // 按钮面板配置
        JPanel btns = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        btns.setBackground(new Color(0xf0, 0xf0, 0xf0));
        btns.add(sendBn);

        sendBn.addActionListener(e->{
            sendmsgtoserver();
        });

        // 组装底部面板
        bottomPanel.add(smsSendScrollPane, BorderLayout.CENTER);
        bottomPanel.add(btns, BorderLayout.EAST);

        // 在线用户列表滚动面板
        JScrollPane userListScrollPane = new JScrollPane(onLineUsers);
        userListScrollPane.setBorder(BorderFactory.createEmptyBorder());
        userListScrollPane.setPreferredSize(new Dimension(120, 500));

        // 中心消息面板滚动面板
        JScrollPane smsContentScrollPane = new JScrollPane(smsContent);
        smsContentScrollPane.setBorder(BorderFactory.createEmptyBorder());

        // 将所有组件添加到窗口中
        this.add(smsContentScrollPane, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
        this.add(userListScrollPane, BorderLayout.EAST);
    }

    private void sendmsgtoserver() {
        try {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeInt(2);
            String msg =  smsSend.getText();
            dos.writeUTF(msg);
            dos.flush();
            smsSend.setText("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateonlinelist(String[] userlist)
    {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String user : userlist) {
            listModel.addElement(user);
        }
        onLineUsers.setModel(listModel);
    }

    public void showontable() throws IOException {
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        String msg = dis.readUTF();

        smsContent.append(msg+"\n");

    }
}

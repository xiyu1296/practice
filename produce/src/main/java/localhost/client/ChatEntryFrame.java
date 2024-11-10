package localhost.client;

import javax.swing.*;
import java.awt.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * localhost.client.ChatEntryFrame 类用于创建一个用户输入昵称以进入聊天室的窗口
 * 它继承自 JFrame，并设置了窗口的大小、位置和关闭操作
 * 此外，它还包含了用户输入昵称的文本框以及进入和取消按钮
 */
public class ChatEntryFrame extends JFrame {

    // 用户输入昵称的文本框
    private JTextField nicknameField;
    // 进入聊天室的按钮
    private JButton enterButton;
    // 取消按钮
    private JButton cancelButton;

    Socket socket;


    /**
     * localhost.client.ChatEntryFrame 构造方法用于初始化聊天室入口窗口
     * 它设置了窗口的标题、大小、关闭操作，并确保窗口在屏幕中央显示且不可调整大小
     * 此外，它还负责构建窗口的各个组件，包括标签、文本框和按钮，并为按钮添加事件监听器
     */
    public ChatEntryFrame() throws IOException {
        setTitle("局域网聊天室");
        setSize(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false); // 禁止调整大小

        // 设置背景颜色
        getContentPane().setBackground(Color.decode("#F0F0F0"));

        // 创建主面板并设置布局
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.decode("#F0F0F0"));
        add(mainPanel);

        // 创建顶部面板
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        topPanel.setBackground(Color.decode("#F0F0F0"));

        // 标签和文本框

        // 创建昵称标签
        JLabel nicknameLabel = new JLabel("昵称:");
        // 设置标签字体为楷体，粗体，大小为16
        nicknameLabel.setFont(new Font("楷体", Font.BOLD, 16));

        // 创建昵称输入框，初始容量为10个字符
        nicknameField = new JTextField(10);
        // 设置输入框字体为楷体，常规样式，大小为16
        nicknameField.setFont(new Font("楷体", Font.PLAIN, 16));
        // 设置输入框边框为灰色单线边框，并且内边距为5像素
        nicknameField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        topPanel.add(nicknameLabel);
        topPanel.add(nicknameField);
        mainPanel.add(topPanel, BorderLayout.NORTH);

        // 按钮面板
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(Color.decode("#F0F0F0"));

        // 进入按钮
        enterButton = new JButton("进入");
        enterButton.setFont(new Font("楷体", Font.BOLD, 16));
        enterButton.setBackground(Color.decode("#007BFF"));
        enterButton.setForeground(Color.WHITE);
        enterButton.setBorderPainted(false);
        enterButton.setFocusPainted(false);

        // 取消按钮
        cancelButton = new JButton("取消");
        cancelButton.setFont(new Font("楷体", Font.BOLD, 16));
        cancelButton.setBackground(Color.decode("#DC3545"));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBorderPainted(false);
        cancelButton.setFocusPainted(false);

        buttonPanel.add(enterButton);
        buttonPanel.add(cancelButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // 添加监听器
        enterButton.addActionListener(e -> {
            String nickname = nicknameField.getText();
            if (!nickname.isEmpty()) {
                // 进入聊天室逻辑
                try {
                    login(nickname);
                    new ClientChatFrame(socket,nickname);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                dispose(); // 关闭窗口
            } else {
                JOptionPane.showMessageDialog(this, "请输入昵称!");
            }
        });

        cancelButton.addActionListener(e -> System.exit(0));

        this.setVisible(true);
    }

    private void login(String nickname) throws IOException {
        socket = new Socket("127.0.0.1",8888);

        DataOutputStream dos = new  DataOutputStream(socket.getOutputStream());

        dos.writeInt(1);
        dos.writeUTF(nickname);
        dos.flush();
    }

    /**
     * 主方法，程序入口
     * 创建并显示 localhost.client.ChatEntryFrame 实例
     * @param args 命令行参数
     */

}

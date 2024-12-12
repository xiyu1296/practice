package multiproceed.common;


import multiproceed.common.socket.Client;
import multiproceed.gui.LoginFrame;

import javax.swing.*;
import java.awt.*;


public class MainWithGUI {
    public static void main(String[] args) {
        Client client = new Client();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                    try {

                        JFrame loginFrame = new LoginFrame(client);
                        loginFrame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

            }
        });
    }
}

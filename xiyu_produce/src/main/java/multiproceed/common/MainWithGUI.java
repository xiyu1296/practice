package multiproceed.common;


import multiproceed.gui.LoginFrame;

import javax.swing.*;
import java.awt.*;


public class MainWithGUI {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame loginFrame = new LoginFrame();
                    loginFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

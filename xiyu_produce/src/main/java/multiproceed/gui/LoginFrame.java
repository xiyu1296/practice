/*
 * Created by JFormDesigner on Thu Nov 24 14:57:04 CST 2022
 */

package multiproceed.gui;

import multiproceed.common.socket.Client;
import multiproceed.common.tool.DataProcessing;
import multiproceed.common.users.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;

/**
 * @author unknown
 */
public class LoginFrame extends JFrame {
    public LoginFrame(Client client) {

        initComponents(client);
    }

    private void loginButtonAction(Client client) {
        String account, password;
        account = accountInput.getText();
        password = passwordInput.getText();
        User user = DataProcessing.checkPassword(account, password);
        try {
            if (user == null) {
                infoLable.setText("密码错误，请重试");
                client.SendMessage("FAILED LOGIN: " + account);
                client.ReceiveMessage();
            } else {
                infoLable.setText("登录成功");
                client.SendMessage("LOGIN: " + user.getName());
                client.ReceiveMessage();
                JFrame mainFrame = new MainFrame(user,client);
                this.setVisible(false);
                mainFrame.setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private void initComponents(Client client) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        titlePanel = new JPanel();
        label1 = new JLabel();
        contentPanel = new JPanel();
        inputPanel = new JPanel();
        accountLable = new JLabel();
        accountInput = new JTextField();
        passwordLable = new JLabel();
        passwordInput = new JTextField();
        buttonBar = new JPanel();
        infoLable = new JLabel();
        loginButton = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== titlePanel ========
            {
                titlePanel.setLayout(new FlowLayout());

                //---- label1 ----
                label1.setText("\u767b\u5f55\u6863\u6848\u7ba1\u7406\u7cfb\u7edf");
                titlePanel.add(label1);
            }
            dialogPane.add(titlePanel, BorderLayout.NORTH);

            //======== contentPanel ========
            {
                contentPanel.setLayout(new BorderLayout());

                //======== inputPanel ========
                {

                    //---- accountLable ----
                    accountLable.setText("\u8d26\u53f7");

                    //---- passwordLable ----
                    passwordLable.setText("\u5bc6\u7801");

                    GroupLayout inputPanelLayout = new GroupLayout(inputPanel);
                    inputPanel.setLayout(inputPanelLayout);
                    inputPanelLayout.setHorizontalGroup(
                        inputPanelLayout.createParallelGroup()
                            .addGroup(inputPanelLayout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addGroup(inputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(accountLable, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                                    .addComponent(passwordLable, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(inputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(passwordInput, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                    .addComponent(accountInput, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                                .addGap(68, 68, 68))
                    );
                    inputPanelLayout.setVerticalGroup(
                        inputPanelLayout.createParallelGroup()
                            .addGroup(inputPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(inputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(accountLable, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(accountInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(inputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(passwordLable, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(10, Short.MAX_VALUE))
                    );
                }
                contentPanel.add(inputPanel, BorderLayout.NORTH);
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0};
                buttonBar.add(infoLable, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- loginButton ----
                loginButton.setText("\u767b\u5f55");
                loginButton.addActionListener(e -> loginButtonAction(client));
                buttonBar.add(loginButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel titlePanel;
    private JLabel label1;
    private JPanel contentPanel;
    private JPanel inputPanel;
    private JLabel accountLable;
    private JTextField accountInput;
    private JLabel passwordLable;
    private JTextField passwordInput;
    private JPanel buttonBar;
    private JLabel infoLable;
    private JButton loginButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

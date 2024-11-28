/*
 * Created by JFormDesigner on Thu Nov 24 15:33:16 CST 2022
 */

package multiproceed.gui;

import  multiproceed.common.*;
import multiproceed.common.users.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

/**
 * @author unknown
 */
public class MainFrame extends JFrame {
    private final User user;

    public MainFrame(User user) {
        this.user = user;
        initComponents();
        accountInfo.setText(user.getName());
        roleInfo.setText(user.getRole());
        if (Objects.equals(user.getRole(), "browser")) {
            menu1.setEnabled(false);
            addUser.setEnabled(false);
            deleteUser.setEnabled(false);
            changeUserInfo.setEnabled(false);
            queryUser.setEnabled(false);
            uploadFile.setEnabled(false);
        } else if (Objects.equals(user.getRole(), "operator")) {
            menu1.setEnabled(false);
            addUser.setEnabled(false);
            deleteUser.setEnabled(false);
            changeUserInfo.setEnabled(false);
            queryUser.setEnabled(false);
        }
    }

    private void exitSystemAction(ActionEvent e) {
        System.exit(0);
    }

    private void logoutAction(ActionEvent e) {
        this.dispose();
        try {
            JFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    private void showFileListAction() {
        try {
            JFrame fileList = new FileList();
            fileList.setVisible(true);
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    private void changeSelfPasswordAction() {
        try {
            JFrame changePassword = new ChangePassword(user.getName(), user.getRole());
            changePassword.setVisible(true);
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    private void downloadFileAction() {
        try {
            JFrame downloadFile = new DownloadFile();
            downloadFile.setVisible(true);
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    private void uploadFileAction() {
        try {
            JFrame uploadFile = new UploadFile(user.getName());
            uploadFile.setVisible(true);
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        addUser = new JMenuItem();
        deleteUser = new JMenuItem();
        changeUserInfo = new JMenuItem();
        queryUser = new JMenuItem();
        menu2 = new JMenu();
        showFileList = new JMenuItem();
        uploadFile = new JMenuItem();
        downloadFile = new JMenuItem();
        menu3 = new JMenu();
        changeSelfPassword = new JMenuItem();
        logout = new JMenuItem();
        exitSystem = new JMenuItem();
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        helloLable = new JLabel();
        account = new JLabel();
        role = new JLabel();
        accountInfo = new JLabel();
        roleInfo = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u7528\u6237\u7ba1\u7406");

                //---- addUser ----
                addUser.setText("\u65b0\u589e\u7528\u6237");
                menu1.add(addUser);

                //---- deleteUser ----
                deleteUser.setText("\u5220\u9664\u7528\u6237");
                menu1.add(deleteUser);

                //---- changeUserInfo ----
                changeUserInfo.setText("\u4fee\u6539\u7528\u6237");
                menu1.add(changeUserInfo);

                //---- queryUser ----
                queryUser.setText("\u67e5\u8be2\u7528\u6237");
                menu1.add(queryUser);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("\u6863\u6848\u7ba1\u7406");

                //---- showFileList ----
                showFileList.setText("\u6863\u6848\u5217\u8868");
                showFileList.addActionListener(e -> showFileListAction());
                menu2.add(showFileList);

                //---- uploadFile ----
                uploadFile.setText("\u4e0a\u4f20\u6863\u6848");
                uploadFile.addActionListener(e -> uploadFileAction());
                menu2.add(uploadFile);

                //---- downloadFile ----
                downloadFile.setText("\u4e0b\u8f7d\u6863\u6848");
                downloadFile.addActionListener(e -> downloadFileAction());
                menu2.add(downloadFile);
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("\u6211\u7684\u8d26\u53f7");

                //---- changeSelfPassword ----
                changeSelfPassword.setText("\u4fee\u6539\u5bc6\u7801");
                changeSelfPassword.addActionListener(e -> changeSelfPasswordAction());
                menu3.add(changeSelfPassword);

                //---- logout ----
                logout.setText("\u6ce8\u9500\u767b\u5f55");
                logout.addActionListener(e -> logoutAction(e));
                menu3.add(logout);

                //---- exitSystem ----
                exitSystem.setText("\u9000\u51fa\u7cfb\u7edf");
                exitSystem.addActionListener(e -> exitSystemAction(e));
                menu3.add(exitSystem);
            }
            menuBar1.add(menu3);
        }
        setJMenuBar(menuBar1);

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- helloLable ----
                helloLable.setText("\u6b22\u8fce\u4f7f\u7528\u6863\u6848\u7ba1\u7406\u7cfb\u7edf");

                //---- account ----
                account.setText("\u8d26\u53f7\uff1a");

                //---- role ----
                role.setText("\u7c7b\u522b\uff1a");

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(helloLable)
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(account)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(accountInfo, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(role)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(roleInfo, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(418, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(helloLable)
                            .addGap(18, 18, 18)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(account)
                                .addComponent(accountInfo))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(role)
                                .addComponent(roleInfo))
                            .addContainerGap(272, Short.MAX_VALUE))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem addUser;
    private JMenuItem deleteUser;
    private JMenuItem changeUserInfo;
    private JMenuItem queryUser;
    private JMenu menu2;
    private JMenuItem showFileList;
    private JMenuItem uploadFile;
    private JMenuItem downloadFile;
    private JMenu menu3;
    private JMenuItem changeSelfPassword;
    private JMenuItem logout;
    private JMenuItem exitSystem;
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel helloLable;
    private JLabel account;
    private JLabel role;
    private JLabel accountInfo;
    private JLabel roleInfo;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

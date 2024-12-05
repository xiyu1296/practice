/*
 * Created by JFormDesigner on Thu Dec 01 16:07:52 CST 2022
 */

package multiproceed.gui;


import multiproceed.common.tool.DataProcessing;

import javax.swing.*;

/**
 * @author unknown
 */
public class EditUser extends JFrame {
    public EditUser() {
        initComponents();
    }

    private void handleSubmit() {
        String username = InputUsername.getText();
        String password = InputPassword.getText();
        String role = (String) InputRole.getSelectedItem();
        if (DataProcessing.updateUser(username, password, role))
            Message.setText("修改成功");
        else
            Message.setText("修改失败");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        FormTitle = new JLabel();
        Username = new JLabel();
        Password = new JLabel();
        Role = new JLabel();
        InputUsername = new JTextField();
        InputPassword = new JTextField();
        InputRole = new JComboBox<>();
        Submit = new JButton();
        Message = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();

        //---- FormTitle ----
        FormTitle.setText("\u4fee\u6539\u7528\u6237");

        //---- Username ----
        Username.setText("\u7528\u6237\u540d");

        //---- Password ----
        Password.setText("\u5bc6\u7801");

        //---- Role ----
        Role.setText("\u6743\u9650");

        //---- InputRole ----
        InputRole.setModel(new DefaultComboBoxModel<>(new String[]{
                "admin",
                "operator",
                "browser"
        }));

        //---- Submit ----
        Submit.setText("\u521b\u5efa");
        Submit.addActionListener(e -> handleSubmit());

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(contentPaneLayout.createParallelGroup()
                                                .addGroup(contentPaneLayout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addComponent(FormTitle))
                                                .addGroup(contentPaneLayout.createSequentialGroup()
                                                        .addGap(38, 38, 38)
                                                        .addComponent(Username)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(InputUsername, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(Password)
                                                        .addComponent(Role))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(InputRole, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                                        .addComponent(InputPassword, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))))
                                .addContainerGap(53, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addGap(0, 47, Short.MAX_VALUE)
                                .addComponent(Message, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Submit)
                                .addGap(20, 20, 20))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(FormTitle)
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(InputUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Username))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(InputPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Password))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(InputRole, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Role))
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(Submit)
                                        .addComponent(Message))
                                .addContainerGap(16, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel FormTitle;
    private JLabel Username;
    private JLabel Password;
    private JLabel Role;
    private JTextField InputUsername;
    private JTextField InputPassword;
    private JComboBox<String> InputRole;
    private JButton Submit;
    private JLabel Message;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

/*
 * Created by JFormDesigner on Thu Dec 01 16:32:52 CST 2022
 */

package multiproceed.gui;


import multiproceed.common.tool.DataProcessing;

import javax.swing.*;

/**
 * @author unknown
 */
public class DeleteUser extends JFrame {
    public DeleteUser() {
        initComponents();
    }

    private void handleSubmit() {
        String username = InputUsername.getText();
        if (DataProcessing.deleteUser(username))
            Message.setText("删除成功");
        else
            Message.setText("删除失败");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        FormTitle = new JLabel();
        Username = new JLabel();
        InputUsername = new JTextField();
        Submit = new JButton();
        Message = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();

        //---- FormTitle ----
        FormTitle.setText("\u5220\u9664\u7528\u6237");

        //---- Username ----
        Username.setText("\u7528\u6237\u540d");

        //---- Submit ----
        Submit.setText("\u5220\u9664");
        Submit.addActionListener(e -> handleSubmit());

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(FormTitle))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(Message, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Submit))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(Username)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(InputUsername, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)))))
                    .addContainerGap(23, Short.MAX_VALUE))
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
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(Message, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                        .addComponent(Submit))
                    .addContainerGap(20, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel FormTitle;
    private JLabel Username;
    private JTextField InputUsername;
    private JButton Submit;
    private JLabel Message;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

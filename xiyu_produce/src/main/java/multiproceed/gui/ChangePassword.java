/*
 * Created by JFormDesigner on Thu Nov 24 16:22:25 CST 2022
 */

package multiproceed.gui;

import multiproceed.common.tool.DataProcessing;

import javax.swing.*;
import java.util.Objects;

/**
 * @author unknown
 */
public class ChangePassword extends JFrame {
    private final String name;
    private final String role;

    public ChangePassword(String name, String role) {
        this.name = name;
        this.role = role;
        initComponents();
    }

    private void SubmitAction() {
        String new_password, confirm_password;
        new_password = NewPassword.getText();
        confirm_password = RepeatPassword.getText();
        if (Objects.equals(new_password, confirm_password)) {
            DataProcessing.updateUser(this.name, new_password, this.role);
            WarningLable.setText("密码修改完成，注销登录后将生效");
        } else {
            WarningLable.setText("两次密码不一致，请重试");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        InfoLable = new JLabel();
        NewPasswordLable = new JLabel();
        RepeatPasswordLable = new JLabel();
        NewPassword = new JTextField();
        RepeatPassword = new JTextField();
        Submit = new JButton();
        WarningLable = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();

        //---- InfoLable ----
        InfoLable.setText("\u4fee\u6539\u5bc6\u7801");

        //---- NewPasswordLable ----
        NewPasswordLable.setText("\u8f93\u5165\u65b0\u5bc6\u7801");

        //---- RepeatPasswordLable ----
        RepeatPasswordLable.setText("\u91cd\u590d\u65b0\u5bc6\u7801");

        //---- Submit ----
        Submit.setText("\u786e\u8ba4");
        Submit.addActionListener(e -> SubmitAction());

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(InfoLable)
                    .addContainerGap(254, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(0, 38, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(NewPasswordLable)
                            .addGap(18, 18, 18)
                            .addComponent(NewPassword, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(RepeatPasswordLable)
                            .addGap(18, 18, 18)
                            .addComponent(RepeatPassword, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)))
                    .addGap(44, 44, 44))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(WarningLable, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(Submit)
                    .addGap(16, 16, 16))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(InfoLable)
                    .addGap(32, 32, 32)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(NewPasswordLable)
                        .addComponent(NewPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(RepeatPasswordLable)
                        .addComponent(RepeatPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Submit)
                        .addComponent(WarningLable, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addGap(20, 20, 20))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel InfoLable;
    private JLabel NewPasswordLable;
    private JLabel RepeatPasswordLable;
    private JTextField NewPassword;
    private JTextField RepeatPassword;
    private JButton Submit;
    private JLabel WarningLable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

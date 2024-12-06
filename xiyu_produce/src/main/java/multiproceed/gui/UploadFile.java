/*
 * Created by JFormDesigner on Thu Nov 24 16:43:43 CST 2022
 */

package multiproceed.gui;


import multiproceed.common.tool.DataProcessing;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;

/**
 * @author unknown
 */
public class UploadFile extends JFrame {
    String upload_path = ".\\upload";
    String download_path = ".\\download";
    private final String name;

    public UploadFile(String name) {
        this.name = name;
        initComponents();
    }

    private void StartAction() {
        String dir = DirInput.getText();
        String description = DiscriptionInput.getText();

        byte[] buffer = new byte[1024];
        File temp_file = new File(dir);
        String filename = temp_file.getName();
        if (!DataProcessing.addDocument(filename, name, new Timestamp(System.currentTimeMillis()), description)) {
            return;
        }
        //将dir文件复制到upload路径下
        Path source = Paths.get(dir);
        Path target = Paths.get(upload_path, filename);
        try {
            // 复制文件
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
            WarningLable.setText("上传失败");
            return;
        }
        WarningLable.setText("上传成功");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        InfoLable = new JLabel();
        Start = new JButton();
        WarningLable = new JLabel();
        DirLable = new JLabel();
        DirInput = new JTextField();
        DiscriptionLable = new JLabel();
        DiscriptionInput = new JTextField();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();

        //---- InfoLable ----
        InfoLable.setText("\u4e0a\u4f20\u6587\u4ef6");

        //---- Start ----
        Start.setText("\u4e0a\u4f20");
        Start.addActionListener(e -> StartAction());

        //---- DirLable ----
        DirLable.setText("\u8def\u5f84");

        //---- DiscriptionLable ----
        DiscriptionLable.setText("\u63cf\u8ff0");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(InfoLable)
                    .addContainerGap(254, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(WarningLable, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addGap(103, 103, 103))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(28, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(180, 180, 180)
                            .addComponent(Start))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(DirLable)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(DirInput, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(DiscriptionLable)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(DiscriptionInput, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)))
                            .addGap(5, 5, 5)))
                    .addGap(22, 22, 22))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(InfoLable)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(DirInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(DirLable))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(DiscriptionInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(DiscriptionLable))
                    .addGap(18, 18, 18)
                    .addComponent(Start)
                    .addGap(24, 24, 24)
                    .addComponent(WarningLable)
                    .addGap(46, 46, 46))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel InfoLable;
    private JButton Start;
    private JLabel WarningLable;
    private JLabel DirLable;
    private JTextField DirInput;
    private JLabel DiscriptionLable;
    private JTextField DiscriptionInput;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

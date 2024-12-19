/*
 * Created by JFormDesigner on Thu Nov 24 16:43:43 CST 2022
 */

package multiproceed.gui;


import multiproceed.common.socket.Client;
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
    Client client;

    public UploadFile(String name,Client client)  {
        this.client = client;
        this.name = name;
        initComponents();
    }

    private void StartAction() {
        File selectedFile = DirInput.getSelectedFile();
        String description = DiscriptionInput.getText();

        byte[] buffer = new byte[1024];
        String filename = selectedFile.getName();
        if(DataProcessing.searchDocumentbyname(filename) != null){
            WarningLable.setText("上传失败：文件已存在");
            return;
        }
        try {
            DataProcessing.addDocument(filename, name, new Timestamp(System.currentTimeMillis()), description);
            //将dir文件复制到upload路径下
            Path source = Paths.get(selectedFile.getAbsolutePath());
            Path target = Paths.get(upload_path, filename);

            try {
                // 复制文件
                Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
                WarningLable.setText("上传失败");
                return;
            }

                client.SendMessage("upload " + filename + " " + description + " " );

        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e);
        }

        WarningLable.setText("上传成功");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        InfoLable = new JLabel();
        Start = new JButton();
        WarningLable = new JLabel();
        DirLable = new JLabel();
        DirInput = new JFileChooser();
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
                    .addGap(18, 18, 18)
                    .addComponent(DiscriptionLable)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(WarningLable, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                        .addComponent(DiscriptionInput, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                    .addComponent(Start)
                    .addGap(7, 7, 7))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(InfoLable))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(DirLable)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(DirInput, GroupLayout.PREFERRED_SIZE, 564, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(21, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(InfoLable)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(DirLable)
                            .addGap(0, 285, Short.MAX_VALUE))
                        .addComponent(DirInput, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(DiscriptionLable)
                        .addComponent(DiscriptionInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(35, 35, 35)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(Start)
                        .addComponent(WarningLable, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(27, 27, 27))
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
    private JFileChooser DirInput;
    private JLabel DiscriptionLable;
    private JTextField DiscriptionInput;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

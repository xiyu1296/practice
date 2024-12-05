/*
 * Created by JFormDesigner on Thu Nov 24 16:35:12 CST 2022
 */

package multiproceed.gui;


import multiproceed.common.tool.DataProcessing;
import multiproceed.common.tool.Document;

import javax.swing.*;
import java.io.*;

/**
 * @author unknown
 */
public class DownloadFile extends JFrame {
    String upload_path = ".\\upload\\";
    String download_path = ".\\download\\";

    public DownloadFile() {
        initComponents();
    }

    private void StartAction() {
        int ID = Integer.parseInt(IdInput.getText());
        byte[] buffer = new byte[1024];
        Document doc = DataProcessing.searchDocument(ID);
        if (doc == null) {
            WarningLable.setText("下载失败：未找到该文件");
            return;
        }
        File temp_file = new File(upload_path + doc.getFilename());
        String file_name = temp_file.getName();
        try {
            BufferedInputStream infile = new BufferedInputStream(new FileInputStream(temp_file));
            BufferedOutputStream targetfile = new BufferedOutputStream(new FileOutputStream(download_path + file_name));
            while (true) {
                int byteRead = infile.read(buffer);
                if (byteRead == -1) break;
                targetfile.write(buffer, 0, byteRead);
            }
            infile.close();
            targetfile.close();
        } catch (IOException e) {
            WarningLable.setText("下载失败");
            return;
        }
        WarningLable.setText("下载成功");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        InfoLable = new JLabel();
        IdInput = new JTextField();
        IdLable = new JLabel();
        Start = new JButton();
        WarningLable = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();

        //---- InfoLable ----
        InfoLable.setText("\u4e0b\u8f7d\u6587\u4ef6");

        //---- IdLable ----
        IdLable.setText("\u6587\u4ef6ID");

        //---- Start ----
        Start.setText("\u4e0b\u8f7d");
        Start.addActionListener(e -> StartAction());

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(InfoLable)
                    .addContainerGap(254, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(IdLable)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(IdInput, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(WarningLable, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Start)))
                    .addGap(19, 19, 19))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(InfoLable)
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(IdLable)
                        .addComponent(IdInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Start)
                        .addComponent(WarningLable))
                    .addGap(16, 16, 16))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel InfoLable;
    private JTextField IdInput;
    private JLabel IdLable;
    private JButton Start;
    private JLabel WarningLable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

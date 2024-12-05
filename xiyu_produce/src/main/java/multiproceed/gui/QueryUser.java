/*
 * Created by JFormDesigner on Thu Dec 01 16:36:42 CST 2022
 */

package multiproceed.gui;



import multiproceed.common.tool.DataProcessing;
import multiproceed.common.users.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @author unknown
 */
public class QueryUser extends JFrame {
    public QueryUser() {
        initComponents();
        Enumeration<User> all_users = DataProcessing.getAllUser();
        User temp;
        Vector<String> column = new Vector<String>();
        column.add("Username");
        column.add("Password");
        column.add("Role");
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        while (all_users.hasMoreElements()) {
            Vector<String> row = new Vector<String>();
            temp = all_users.nextElement();
            row.add(temp.getName());
            row.add(temp.getPassword());
            row.add(temp.getRole());
            data.add(row);
        }
        infoTable.setModel(new DefaultTableModel(data, column));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        infoTable = new JTable();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u7528\u6237\u5217\u8868");

        //======== scrollPane1 ========
        {

            //---- infoTable ----
            infoTable.setEnabled(false);
            scrollPane1.setViewportView(infoTable);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(label1)
                                                .addContainerGap(554, Short.MAX_VALUE))))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                                .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable infoTable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

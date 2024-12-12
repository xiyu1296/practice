package trial2;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SumAndAverageApp2 {
    /**
     * 程序的入口点
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 使用SwingUtilities在事件调度线程中运行程序
        SwingUtilities.invokeLater(SumAndAverageApp2::createAndShowGUI);
    }

    /**
     * 创建并显示图形用户界面
     */
    private static void createAndShowGUI() {
        // 创建主窗口
        JFrame frame = new JFrame("和与平均值");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // 创建输入文本区
        JLabel inputLabel = new JLabel("请输入数字（用逗号分隔）:");
        JTextArea inputArea = new JTextArea(5, 30);
        JScrollPane scrollPane = new JScrollPane(inputArea);

        // 创建和与平均值的显示区域
        JPanel displayPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel sumLabel = new JLabel("和值:");
        JTextField sumField = new JTextField(20);
        sumField.setEditable(false);

        JLabel avgLabel = new JLabel("平均值:");
        JTextField avgField = new JTextField(20);
        avgField.setEditable(false);

        // 布局显示面板
        gbc.gridx = 0;
        gbc.gridy = 0;
        displayPanel.add(sumLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        displayPanel.add(sumField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        displayPanel.add(avgLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        displayPanel.add(avgField, gbc);

        // 添加计算按钮
        JButton calculateButton = new JButton("计算");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFields(inputArea, sumField, avgField);
            }
        });

        // 添加组件到主窗口
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(inputLabel, BorderLayout.WEST);
        topPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calculateButton);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(displayPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    /**
     * 更新和与平均值的显示字段
     * @param inputArea 输入文本区域
     * @param sumField 显示和值的文本字段
     * @param avgField 显示平均值的文本字段
     */
    private static void updateFields(JTextArea inputArea, JTextField sumField, JTextField avgField) {
        try {
            String input = inputArea.getText();
            if (input == null || input.trim().isEmpty()) {
                sumField.setText("");
                avgField.setText("");
                return;
            }
            String[] numbers = input.split(",");
            double sum = 0;
            int count = 0;
            for (String num : numbers) {
                if (num.trim().isEmpty()) continue;
                sum += Double.parseDouble(num.trim());
                count++;
            }
            if (count == 0) {
                sumField.setText("");
                avgField.setText("");
                return;
            }
            double avg = sum / count;
            sumField.setText(String.valueOf(sum));
            avgField.setText(String.valueOf(avg));
        } catch (NumberFormatException ex) {
            sumField.setText("输入包含无效的数字");
            avgField.setText("输入包含无效的数字");
        }
    }
}

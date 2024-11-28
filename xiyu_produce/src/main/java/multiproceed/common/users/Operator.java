package multiproceed.common.users;

import multiproceed.common.tool.DataProcessing;

import java.io.*;
import java.sql.Timestamp;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Operator extends User {
    public Operator(String name, String password, String role) {
        super(name, password, role);
    }

    public void showMenu() {
        while (true) {
            String menu_str = """
                    ========档案录入员========
                    1. 上传文件
                    2. 下载文件
                    3. 文件列表
                    4. 修改密码（本账号）
                    5. 注销登录
                    6. 退出系统
                    选择操作:\040""";
            System.out.print(menu_str);
            Scanner sc = new Scanner(System.in);
            int choice;
            // 选项合法性检查
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("选项错误，请重试");
                continue;
            }
            switch (choice) {
                case 1 -> uploadFile();
                case 2 -> downloadFile();
                case 3 -> showFileList();
                case 4 -> changeSelfPassword();
                case 5 -> {
                    return;
                }
                case 6 -> exitSystem();
                default -> System.out.println("选项错误，请重试");
            }
        }
    }

    public void uploadFile() {
        System.out.println("========上传文件========");
        Scanner sc = new Scanner(System.in);
        System.out.print("输入文件ID: ");
        String ID = sc.next();
        System.out.print("输入文件路径: ");
        String dir = sc.next();
        System.out.print("输入文件描述: ");
        String description = sc.next();

        byte[] buffer = new byte[1024];
        File temp_file = new File(dir);
        String filename = temp_file.getName();
        if (!DataProcessing.addDocument(ID, filename, getName(), new Timestamp(System.currentTimeMillis()), description)) {
            System.out.println("上传失败：文件ID重复");
            return;
        }
        try {
            BufferedInputStream infile = new BufferedInputStream(new FileInputStream(temp_file));
            BufferedOutputStream targetfile = new BufferedOutputStream(new FileOutputStream(upload_path + filename));
            while (true) {
                int byteRead = infile.read(buffer);
                if (byteRead == -1) break;
                targetfile.write(buffer, 0, byteRead);
            }
            infile.close();
            targetfile.close();
        } catch (IOException e) {
            System.out.println("上传失败");
            return;
        }
        System.out.println("上传成功");
    }
}

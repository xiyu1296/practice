package multiproceed.common.users;

import multiproceed.common.tool.DataProcessing;
import multiproceed.common.tool.Document;

import java.io.*;
import java.util.Enumeration;
import java.util.Objects;
import java.util.Scanner;

public abstract class User {
    private String name;
    private String password;
    private String role;

    String upload_path = ".\\upload\\";
    String download_path = ".\\download\\";

    User(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public abstract void showMenu();

    public void setName(String value) {
        name = value;
    }

    public void setPassword(String value) {
        password = value;
    }

    public void setRole(String value) {
        role = value;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void showFileList() {
        System.out.println("========文件列表========");
        Enumeration<Document> all_docs = DataProcessing.getAllDocument();
        Document temp;
        System.out.printf("%5s%20s%30s%15s\n", "ID", "FileName", "Description", "Creator");
        while (all_docs.hasMoreElements()) {
            temp = all_docs.nextElement();
            System.out.printf("%5s%20s%30s%15s\n", temp.getID(), temp.getFilename(), temp.getDescription(), temp.getCreator());
        }
    }

    public void downloadFile() {
        System.out.println("========下载文件========");
        System.out.print("输入文件ID: ");
        Scanner sc = new Scanner(System.in);
        int ID = sc.nextInt();
        byte[] buffer = new byte[1024];
        Document doc = DataProcessing.searchDocument(ID);
        if (doc == null) {
            System.out.println("下载失败：未找到该文件");
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
            System.out.println("下载失败");
            return;
        }
        System.out.println("下载成功");
    }

    public void changeSelfPassword() {
        String menu_str = "========修改密码========";
        System.out.println(menu_str);
        String new_password, confirm_password;
        System.out.print("输入新密码: ");
        Scanner sc = new Scanner(System.in);
        new_password = sc.next();
        System.out.print("确认新密码: ");
        confirm_password = sc.next();
        if (Objects.equals(new_password, confirm_password)) {
            DataProcessing.updateUser(this.name, new_password, this.role);
            System.out.println("密码修改完成，注销登录后将生效");
        } else {
            System.out.println("两次密码不一致，请重试");
        }
    }

    public void exitSystem() {
        System.out.println("系统退出");
        System.exit(0);
    }
}


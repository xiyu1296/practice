package multiproceed.common.users;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Browser extends User {
    public Browser(String name, String password, String role) {
        super(name, password, role);
    }

    public void showMenu() {
        while (true) {
            String menu_str = """
                    ========档案浏览员========
                    1. 下载文件
                    2. 文件列表
                    3. 修改密码（本账号）
                    4. 注销登录
                    5. 退出系统
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
                case 1 -> downloadFile();
                case 2 -> showFileList();
                case 3 -> changeSelfPassword();
                case 4 -> {
                    return;
                }
                case 5 -> exitSystem();
                default -> System.out.println("选项错误，请重试");
            }
        }
    }
}

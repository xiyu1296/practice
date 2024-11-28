package multiproceed.common.users;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin extends User {
    public Admin(String name, String password, String role) {
        super(name, password, role);
    }

    public void showMenu() {
        while (true) {
            String menu_str = """
                    ========档案管理员========
                    1. 新增用户
                    2. 删除用户
                    3. 修改用户
                    4. 查询用户
                    5. 下载文件
                    6. 文件列表
                    7. 修改密码（本账号）
                    8. 注销登录
                    9. 退出系统
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
                case 1 -> addUser();
                case 2 -> deleteUser();
                case 3 -> changeUserInfo();
                case 4 -> queryUser();
                case 5 -> downloadFile();
                case 6 -> showFileList();
                case 7 -> changeSelfPassword();
                case 8 -> {
                    return;
                }
                case 9 -> exitSystem();
                default -> System.out.println("选项错误，请重试");
            }
        }
    }

    public void changeUserInfo() {
        String menu_str = """
                ========修改用户========
                WIP
                """;
        System.out.println(menu_str);
    }

    public void addUser() {
        String menu_str = """
                ========新增用户========
                WIP
                """;
        System.out.println(menu_str);
    }

    public void deleteUser() {
        String menu_str = """
                ========删除用户========
                WIP
                """;
        System.out.println(menu_str);
    }

    public void queryUser() {
        String menu_str = """
                ========查询用户========
                WIP
                """;
        System.out.println(menu_str);
    }
}

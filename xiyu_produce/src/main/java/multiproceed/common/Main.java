package multiproceed.common;

import multiproceed.common.tool.DataProcessing;
import multiproceed.common.users.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            String menu_str = """
                    ========欢迎进入档案系统========
                    1. 登录
                    2. 退出
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
            if (choice == 1) {
                User user = login();
                if (user == null) {
                    System.out.println("密码错误，请重试");
                    continue;
                }
                user.showMenu();
            } else if (choice == 2) {
                break;
            } else {
                System.out.println("选项错误，请重试");
            }
        }
        System.out.println("程序退出");
    }

    public static User login() {
        Scanner sc = new Scanner(System.in);
        String name, password;
        System.out.print("输入用户名: ");
        name = sc.next();
        System.out.print("输入密码: ");
        password = sc.next();
        return DataProcessing.checkPassword(name, password);
    }
}

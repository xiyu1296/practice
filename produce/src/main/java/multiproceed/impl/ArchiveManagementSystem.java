package multiproceed.impl;

import multiproceed.abstacts_class.opera.dataproc;
import multiproceed.abstacts_class.usr.Administrator;
import multiproceed.abstacts_class.usr.Browser;
import multiproceed.abstacts_class.usr.Operator;
import multiproceed.abstacts_class.usr.user;

import java.util.Scanner;

public class ArchiveManagementSystem {
    public static void main(String[] args) {
        dataproc dataproc = new dataproc();

        // 预先存储的用户信息
        dataproc.adduser(new Administrator("admin", "admin123"));
        dataproc.adduser(new Operator("operator", "op123"));
        dataproc.adduser(new Browser("viewer", "view123"));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        user user = dataproc.getuser(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful!");
            user.showMenu();
        } else {
            System.out.println("Invalid username or password.");
        }

        scanner.close();
    }
}
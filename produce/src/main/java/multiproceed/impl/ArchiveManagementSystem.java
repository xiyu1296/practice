package multiproceed.impl;

import multiproceed.abstacts_class.opera.dataproc;
import multiproceed.abstacts_class.usr.Administrator;
import multiproceed.abstacts_class.usr.Browser;
import multiproceed.abstacts_class.usr.Operator;
import multiproceed.abstacts_class.usr.User;

import java.util.Scanner;

public class ArchiveManagementSystem {
    public static void main(String[] args) {
        dataproc dataproc = new dataproc();

        // 预先存储的用户信息
        dataproc.addUser(new Administrator("admin", "admin123"));
        dataproc.addUser(new Operator("operator", "op123"));
        dataproc.addUser(new Browser("viewer", "view123"));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Username: ");
        String Username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User User = dataproc.getUser(Username);
        if (User != null && User.getPassword().equals(password)) {
            System.out.println("Login successful!");
            User.showMenu();
        } else {
            System.out.println("Invalid Username or password.");
        }

        scanner.close();
    }
}
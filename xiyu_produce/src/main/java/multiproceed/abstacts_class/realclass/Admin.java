package multiproceed.abstacts_class.realclass;

import multiproceed.abstacts_class.usr.User;

public class Admin extends User {

    public Admin(String name, String password,String role) {
        super(name, password, role);
    }

    @Override
    public void showMenu() {
        System.out.println("Administrator Menu: 1. Add User 2. Delete User 3. Change User Info 4. List Users");
    }

    public void addUser() {
        System.out.println("Adding user...");
    }

    public void delUser() {
        System.out.println("Deleting user...");
    }

    public void changeUserInfo() {
        System.out.println("Changing user info...");
    }

    public void listUser() {
        System.out.println("Listing users...");
    }
}





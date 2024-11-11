package multiproceed.abstacts_class.usr;

// 管理员类
public class Administrator extends user {
    public Administrator(String username, String password) {
        super(username, password,0);
    }

    @Override
    public void showMenu() {
        System.out.println("Administrator Menu: 1. Manage users 2. System Settings");
    }

    public void changeuserInfo() {
        System.out.println("Changing user info...");
    }

    public void deluser() {
        System.out.println("Deleting a user...");
    }

    public void adduser() {
        System.out.println("adding a user...");
    }

    public void listuser() {
        System.out.println("listing a user...");
    }


}

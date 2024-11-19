package multiproceed.abstacts_class.realclass;

import multiproceed.abstacts_class.usr.User;

public class Browser extends User {

    public Browser(String name, String password,String role) {
        super(name, password, role);
    }

    @Override
    public void showMenu() {
        System.out.println("Browser Menu: 1. View Files");
    }
}

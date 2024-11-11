package multiproceed.abstacts_class.usr;

// 档案浏览人员类
public class Browser extends user {
    public Browser(String username, String password) {
        super(username, password,2);
    }

    @Override
    public void showMenu() {
        System.out.println("Browser Menu: 1. View Files");
    }
}

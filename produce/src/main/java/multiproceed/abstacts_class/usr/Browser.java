package multiproceed.abstacts_class.usr;

/**
 * 档案浏览人员类
 */
public class Browser extends User{
    /**
     * 浏览器用户的权限值
     */
    private static final int BROWSER_PERMISSION = 2;

    /**
     * 构造函数
     *
     * @param username 用户名
     * @param password 密码
     */
    public Browser(String username, String password) {
        super(username, password, BROWSER_PERMISSION);
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username and password cannot be null");
        }
    }

    /**
     * 显示菜单
     */
    @Override
    public void showMenu() {
        System.out.println("Browser Menu: 1. View Files");
    }
}

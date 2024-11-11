package multiproceed.abstacts_class.usr;

// 用户基类
public abstract class user {
    private String username;
    private String password;
    private int user_TYPE;

    public user(String username, String password,int user_TYPE) {
        this.username = username;
        this.password = password;
        this.user_TYPE = user_TYPE;
    }

    public String getusername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    //构建两个参数的set方法
    public void setPassword(String password) {
        this.password = password;
    }

    public void setusername(String username) {
        this.username= username;
    }

    public int getUser_TYPE() {
        return user_TYPE;
    }

    public void exit(){
        System.exit(0);
    }

    public void changeselfInfo() {

    }

    public void showfile() {

    }

    public void downloadfile() {

    }

    public abstract void showMenu();
}






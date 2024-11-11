package multiproceed.abstacts_class.usr;

// 档案录入人员类
public class Operator extends user {
    public Operator(String username, String password) {
        super(username, password,1);
    }


    @Override
    public void showMenu() {
        System.out.println("Operator Menu: 1. Upload File 2. Edit Records");
    }

    public void uploadFile() {
        System.out.println("Uploading file...");
    }
}

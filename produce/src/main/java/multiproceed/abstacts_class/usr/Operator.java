package multiproceed.abstacts_class.usr;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// 档案录入人员类
public class Operator extends User {
    private static final int OPERATOR_PERMISSION = 1;

    public Operator(String username, String password) {
        super(username, password, OPERATOR_PERMISSION);

    }


    @Override
    public void showMenu() {
        System.out.println("Operator Menu: 1. Upload File 2. Edit Records");
    }

    public void uploadFile() {
        System.out.println("Uploading file...");
    }
}

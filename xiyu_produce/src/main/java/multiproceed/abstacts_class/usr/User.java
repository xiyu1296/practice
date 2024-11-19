package multiproceed.abstacts_class.usr;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import org.apache.commons.io.FileUtils;
import static multiproceed.impl.DataProcessing.getAllUser;
import static org.apache.commons.io.FileUtils.writeStringToFile;

@Setter
@Getter
public abstract class User {
    // Getters and Setters
    private String name;
    private String password;
    private String role;

    // Constructor
    public User(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public User() {

    }

    // Abstract and default methods (can be overridden in child classes)
    public abstract void showMenu();

    public void showFileList() {
        Enumeration<User> emp = getAllUser();
        while (emp.hasMoreElements()) {
            User user = emp.nextElement();
            System.out.println(user.getName());
        }
    }

    public void downloadFile() throws IOException {
        Enumeration<User> emo = getAllUser();

        //创建文件字节输出流

        while (emo.hasMoreElements()) {
            User user = emo.nextElement();
            writeStringToFile(new File("src/main/java/multiproceed/files/download"), user.getName()+" "+user.getPassword()+" " +user.getRole()+'\n', "UTF-8");
        }
    }

    public void changeSelfInfo() {
        System.out.println("Changing personal info...");
    }

    public void exitSystem() {
        System.out.println("Exiting system...");
    }
}

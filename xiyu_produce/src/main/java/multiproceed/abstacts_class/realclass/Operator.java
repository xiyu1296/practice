package multiproceed.abstacts_class.realclass;

import multiproceed.abstacts_class.usr.User;
import multiproceed.impl.DataProcessing;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.apache.commons.io.FileUtils.*;

public class Operator extends User {

    public Operator(String name, String password,String role) {
        super(name, password, role);
    }

    @Override
    public void showMenu() {
        System.out.println("Operator Menu: 1. Upload File");
    }

    public void uploadFile() throws IOException {
        copyFile(new File("src/main/java/multiproceed/files/download"), new File("src/main/java/multiproceed/files/upload/"));

        List<String > lst = readLines(new File("src/main/java/multiproceed/files/download"));

        for(String line : lst){
            String[] split = line.split(" ");
            String name = split[0];
            String password = split[1];
            String role = split[2];
            DataProcessing.addUser(name, password, role);
            System.out.println(name+" " +role);
        }
    }
}
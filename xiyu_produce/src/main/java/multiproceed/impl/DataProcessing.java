package multiproceed.impl;

import multiproceed.abstacts_class.realclass.Admin;
import multiproceed.abstacts_class.realclass.Browser;
import multiproceed.abstacts_class.realclass.Operator;
import multiproceed.abstacts_class.usr.User;

import java.sql.Timestamp;
import java.util.Enumeration;
import java.util.Hashtable;

public class DataProcessing {
    static Hashtable<String, User> users;
    static Hashtable<String, Document> docs;

    static {
        users = new Hashtable<String, User>();
        users.put("jack", new Operator("jack", "123", "operator"));
        users.put("rose", new Browser("rose", "123", "browser"));
        users.put("kate", new Admin("kate", "123", "admin"));
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        docs = new Hashtable<String, Document>();
        docs.put("001", new Document("001", "TestDoc.txt", "jack", timestamp, "test document for dev"));
    }

    private static User constructUser(String name, String password, String role) {
        User user;
        if (role.equalsIgnoreCase("admin")) {
            user = new Admin(name, password, role);
        } else if (role.equalsIgnoreCase("operator")) {
            user = new Operator(name, password, role);
        } else if (role.equalsIgnoreCase("browser")) {
            user = new Browser(name, password, role);
        } else {
            return null;
        }
        return user;
    }

    // 增加用户
    public static boolean addUser(String name, String password, String role) {
        if (users.containsKey(name)) return false;
        User user = constructUser(name, password, role); // 构造一个具体的用户类
        if (user == null) return false;
        users.put(name, user);
        return true;
    }

    // 删除用户
    public static boolean deleteUser(String name) {
        if (users.containsKey(name)) {
            users.remove(name);
            return true;
        }
        return false;
    }

    // 修改用户数据
    public static boolean updateUser(String name, String password, String role) {
        if (!users.containsKey(name)) return false;
        User user = constructUser(name, password, role); // 构造一个具体的用户类
        if (user == null) return false;
        users.put(name, user);
        return true;
    }

    // 根据名称取得用户
    public static User searchUser(String name) {
        if (users.containsKey(name)) // 校验用户是否存在
            return users.get(name);
        return null;
    }

    // 校验密码后取得用户
    public static User checkPassword(String name, String password) {
        if (users.containsKey(name)) { // 校验用户是否存在
            User user = users.get(name);
            if (user.getPassword().equals(password)) // 校验用户密码
                return user;
        }
        return null;
    }

    // 取得所有用户数据
    public static Enumeration<User> getAllUser() {
        return users.elements();
    }

    // 增加文档
    public static boolean addDocument(String ID, String filename, String creator, Timestamp timestamp, String description) {
        if (docs.containsKey(ID)) return false;
        Document doc = new Document(ID, filename, creator, timestamp, description);
        docs.put(ID, doc);
        return true;
    }

    // 根据ID取得文档
    public static Document searchDocument(String ID) {
        if (docs.containsKey(ID)) return docs.get((ID));
        return null;
    }

    // 取得所有文档数据
    public static Enumeration<Document> getAllDocument() {
        return docs.elements();
    }
}

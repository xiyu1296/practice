package multiproceed.common.tool;

import multiproceed.common.users.Admin;
import multiproceed.common.users.Browser;
import multiproceed.common.users.Operator;
import multiproceed.common.users.User;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

public class DataProcessing {
    // 连接信息
    private static String DRIVER_NAME;
    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;

    static {
        // 读取配置文件
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("E:\\java\\javacode\\javatotal\\xiyu_produce\\src\\main\\java\\multiproceed\\common\\database.properties"));
            DRIVER_NAME = properties.getProperty("jdbc.driver");
            URL = properties.getProperty("jdbc.url");
            USERNAME = properties.getProperty("jdbc.username");
            PASSWORD = properties.getProperty("jdbc.password");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 注册驱动
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // jdbc对象
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    public static void getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 增加用户
    public static boolean addUser(String name, String password, String role) {
        // 查询用户是否已经存在
        try {
            getConnection();
            String sql = "SELECT * from user WHERE name='" + name + "'";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            int cnt = 0;
            while (resultSet.next())
                cnt++;
            if (cnt > 0)
                return false; // 已存在
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        // 插入用户
        try {
            getConnection();
            String sql = "INSERT INTO user (name, password, role) VALUES " +
                    "('" + name + "', '" + password + "', '" + role + "')";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 删除用户
    public static boolean deleteUser(String name) {
        try {
            getConnection();
            String sql = "DELETE FROM user WHERE name='" + name + "'";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 修改用户数据
    public static boolean updateUser(String name, String password, String role) {
        // 查询用户是否已经存在
        try {
            getConnection();
            String sql = "SELECT * from user WHERE name='" + name + "'";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            int cnt = 0;
            while (resultSet.next())
                cnt++;
            if (cnt == 0)
                return false; // 不存在
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        // 修改数据
        try {
            getConnection();
            String sql = "UPDATE user SET password='" + password + "',role = '" + role + "' WHERE name='" + name + "'";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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

    // 根据名称取得用户
    public static User searchUser(String name) {
        try {
            getConnection();
            String sql = "SELECT * from user WHERE name='" + name + "'";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String password = resultSet.getString("password");
            String role = resultSet.getString("role");
            return constructUser(name, password, role);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 校验密码后取得用户
    public static User checkPassword(String name, String pwd) {
        try {
            getConnection();
            String sql = "SELECT * from user WHERE name='" + name + "'";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String password = resultSet.getString("password");
            String role = resultSet.getString("role");
            if (pwd.equals(password))
                return constructUser(name, password, role);
            else
                return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 取得所有用户数据
    public static Enumeration<User> getAllUser() {
        try {
            getConnection();
            String sql = "SELECT * from user";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            Vector<User> userVector = new Vector<User>();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                userVector.add(constructUser(name, password, role));
            }
            return userVector.elements();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 增加文档
    public static boolean addDocument(String filename, String creator, Timestamp timestamp, String description) {
        try {
            getConnection();
            String sql = "INSERT INTO file (filename, creator, timestamp, description) " +
                    "VALUES ('" + filename + "', '" + creator + "', '" + timestamp + "', '" + description + "')";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 根据ID取得文档
    public static Document searchDocument(int ID) {
        try {
            getConnection();
            String sql = "SELECT * from file WHERE id='" + ID + "'";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String filename = resultSet.getString("filename");
            String creator = resultSet.getString("creator");
            Timestamp timestamp = resultSet.getTimestamp("timestamp");
            String description = resultSet.getString("description");
            return new Document(ID, filename, creator, timestamp, description);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //根据名字获取文档
    public static Document searchDocumentbyname(String filename) {
        try {
            getConnection();
            String sql = "SELECT * from file WHERE filename='" + filename + "'";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int ID = resultSet.getInt("id");
            String creator = resultSet.getString("creator");
            Timestamp timestamp = resultSet.getTimestamp("timestamp");
            String description = resultSet.getString("description");
            return new Document(ID, filename, creator, timestamp, description);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 取得所有文档数据
    public static Enumeration<Document> getAllDocument() {
        try {
            getConnection();
            String sql = "SELECT * from file";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            Vector<Document> documentVector = new Vector<Document>();
            while (resultSet.next()) {
                int ID = resultSet.getInt("id");
                String filename = resultSet.getString("filename");
                String creator = resultSet.getString("creator");
                Timestamp timestamp = resultSet.getTimestamp("timestamp");
                String description = resultSet.getString("description");
                documentVector.add(new Document(ID, filename, creator, timestamp, description));
            }
            return documentVector.elements();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

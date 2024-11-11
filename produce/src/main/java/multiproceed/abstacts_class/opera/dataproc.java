package multiproceed.abstacts_class.opera;

import multiproceed.abstacts_class.usr.User;

import java.util.concurrent.ConcurrentHashMap;

public class dataproc {
    // 数据处理类
    private ConcurrentHashMap<String, User> Users = new ConcurrentHashMap<>();

    /**
     * 添加用户
     * @param User 用户对象
     * @throws IllegalArgumentException 如果用户对象为 null 或用户名为空字符串
     */
    public void addUser(User User) throws IllegalArgumentException {
        if (User == null || User.getUsername() == null || User.getUsername().isEmpty()) {
            throw new IllegalArgumentException("User or Username cannot be null or empty");
        }
        Users.put(User.getUsername(), User);
    }

    /**
     * 获取用户
     * @param Username 用户名
     * @return 用户对象，如果不存在则返回 null
     */
    public User getUser(String Username) {
        if (Username == null || Username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        return Users.get(Username);
    }

    /**
     * 更新用户
     * @param Username 用户名
     * @param User 用户对象
     * @throws IllegalArgumentException 如果用户对象为 null 或用户名为空字符串
     */
    public void updateUser(String Username, User User) throws IllegalArgumentException {
        if (User == null || User.getUsername() == null || User.getUsername().isEmpty()) {
            throw new IllegalArgumentException("User or Username cannot be null or empty");
        }
        Users.put(Username, User);
    }

    /**
     * 删除用户
     * @param Username 用户名
     * @throws IllegalArgumentException 如果用户名为空字符串
     */
    public void deleteUser(String Username) throws IllegalArgumentException {
        if (Username == null || Username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        Users.remove(Username);
    }
}

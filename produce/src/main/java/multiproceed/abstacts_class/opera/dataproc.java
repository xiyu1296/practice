package multiproceed.abstacts_class.opera;

import multiproceed.abstacts_class.usr.user;

import java.util.Hashtable;

public class dataproc {
    // 数据处理类
        private Hashtable<String, user> users = new Hashtable<>();

        public void adduser(user user) {
            users.put(user.getusername(), user);
        }

        public user getuser(String username) {
            return users.get(username);
        }

        public void updateuser(String username, user user) {
            users.put(username, user);
        }

        public void deleteuser(String username) {
            users.remove(username);
        }
    }

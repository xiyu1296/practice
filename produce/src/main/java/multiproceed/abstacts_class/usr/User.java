package multiproceed.abstacts_class.usr;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
      * 用户基类
      */
     public abstract class User {
         private String username;
         private String Password;
         private int user_TYPE;

         /**
          * 构造函数
          *
          * @param username 用户名
          * @param password 密码
          * @param user_TYPE 用户类型
          */
         public User(String username, String password, int user_TYPE) {
             this.username = username;
             this.Password = hashPassword(password);
             this.user_TYPE = user_TYPE;
         }

         /**
          * 获取用户名
          *
          * @return 用户名
          */
         public String getUsername() {
             return username;
         }

         /**
          * 获取密码哈希值
          *
          * @return 密码哈希值
          */
         public String getPassword() {
             return Password;
         }

         /**
          * 设置密码
          *
          * @param password 新密码
          */
         public void setPassword(String password) {
             this.Password = hashPassword(password);
         }

         /**
          * 设置用户名
          *
          * @param username 新用户名
          */
         public void setUsername(String username) {
             this.username = username;
         }

         /**
          * 获取用户类型
          *
          * @return 用户类型
          */
         public int getUser_TYPE() {
             return user_TYPE;
         }

         /**
          * 退出系统
          */
         public void exit() {
             throw new RuntimeException("User requested to exit");
         }

         /**
          * 修改个人信息
          */
         public void changeselfInfo() {
             // 默认实现
         }

         /**
          * 显示文件
          */
         public void showfile() {
             // 默认实现
         }

         /**
          * 下载文件
          */
         public void downloadfile() {
             // 默认实现
         }

         /**
          * 抽象方法，显示菜单
          */
         public abstract void showMenu();

         /**
          * 对密码进行哈希处理
          *
          * @param password 密码
          * @return 密码哈希值
          */
         private String hashPassword(String password) {
             try {
                 MessageDigest md = MessageDigest.getInstance("SHA-256");
                 byte[] hashedBytes = md.digest(password.getBytes());
                 StringBuilder sb = new StringBuilder();
                 for (byte b : hashedBytes) {
                     sb.append(String.format("%02x", b));
                 }
                 return sb.toString();
             } catch (NoSuchAlgorithmException e) {
                 throw new RuntimeException("Hashing algorithm not found", e);
             } catch (Exception e) {
                 throw new RuntimeException("Unexpected error during password hashing", e);
             }
         }
     }
     
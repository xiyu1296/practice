package jdbcwork;//使用java对指定数据库进行sql操作
import java.sql.*;
import java.time.LocalDateTime;

public class sqlTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/book";
        String user = "root";
        String password = "051022";
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        String sql = "select * from books where name like '%Spring%';";
        ResultSet rs = stmt.executeQuery(sql);

        //对rs中的数据进行读取，存储到book类中
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double price = rs.getDouble("price");
            String author = rs.getString("author");
            LocalDateTime time = rs.getTimestamp("publish_date").toLocalDateTime();
            String type = rs.getString("type");
            
            user us = new user(id,name,price,author,time,type);
            System.out.println(
                    us.getId()+" "+us.getName()+" "+us.getPrice()+" "+us.getAuthor()+" "+us.getPublish_date()+" "+us.getType()
            );
        }
        stmt.close();
        conn.close();
        System.out.println("success");

    }
}
   package xiyu1296.xiyu_practice;

   import org.mybatis.spring.annotation.MapperScan;
   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.SpringBootApplication;

   @SpringBootApplication
   @MapperScan("jdbcwork")
   public class XiyuPracticeApplication {
       public static void main(String[] args) {
           SpringApplication.run(XiyuPracticeApplication.class, args);
       }
   }
   
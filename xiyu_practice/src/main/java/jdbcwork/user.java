package jdbcwork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class user {
    int id;
    String name;
    double price;
    String author;
    LocalDateTime publish_date;
    String type;


}

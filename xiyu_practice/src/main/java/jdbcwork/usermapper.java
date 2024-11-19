package jdbcwork;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface usermapper
{
    @Select("select * from books")
    public ArrayList<user> findall();
}

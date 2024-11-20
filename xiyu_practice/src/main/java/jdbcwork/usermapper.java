package jdbcwork;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface usermapper
{
    public ArrayList<user> findall();

    public void adduser(user user);

    public void updateuser(user user);


    public void deleteuser(String name);

}

package xiyu1296.tlias.mapper;

import org.apache.ibatis.annotations.*;
import xiyu1296.tlias.pojo.Dept;

import java.util.List;

@Mapper
public interface deptmapper {

    @Select("select * from dept")
    public List<Dept> list();

    @Delete("delete from dept where id = #{id}")
    void deletebyid(Integer id);


    @Insert("insert into dept(name,create_Time,update_Time) value(#{name},#{createTime},#{updateTime})")
    void add(Dept dept);
}

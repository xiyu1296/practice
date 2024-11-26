package xiyu1296.tlias.mapper;

import org.apache.ibatis.annotations.Mapper;
import xiyu1296.tlias.pojo.Emp;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface empmapper {

    List<Emp> pageselect(String name, Short gender, LocalDateTime starttime,LocalDateTime endtime);
}

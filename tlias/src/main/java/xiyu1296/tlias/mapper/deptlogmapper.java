package xiyu1296.tlias.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.jmx.export.annotation.ManagedOperation;
import xiyu1296.tlias.pojo.DeptLog;

@Mapper
public interface deptlogmapper {

    @Insert("insert into dept_log(create_time,description) values(#{createTime},#{description})")
    void insert(DeptLog deptlog);
}

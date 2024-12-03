package xiyu1296.tlias.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xiyu1296.tlias.mapper.deptmapper;
import xiyu1296.tlias.pojo.Dept;
import xiyu1296.tlias.pojo.DeptLog;
import xiyu1296.tlias.service.deptservice;
import xiyu1296.tlias.service.empservice;

import java.beans.Transient;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class deptserviceimp implements deptservice {

    @Autowired
    private deptmapper Deptmapper;
    @Autowired
    private empservice empService;
    @Autowired
    private deptlogserviceimp Deptlogserviceimp;


    @Override
    public List<Dept> list() {
        return Deptmapper.list();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deletebyid(Integer id) {

        try {
            Deptmapper.deletebyid(id);
            empService.deletebydeptid(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DeptLog dp = new DeptLog( );
            dp.setDescription("删除了部门");
            dp.setCreateTime(LocalDateTime.now());
            Deptlogserviceimp.insert(dp);
        }
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        Deptmapper.add(dept);
    }
}


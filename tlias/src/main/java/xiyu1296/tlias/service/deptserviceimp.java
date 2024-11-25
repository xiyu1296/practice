package xiyu1296.tlias.service;

import jakarta.websocket.OnOpen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xiyu1296.tlias.mapper.deptmapper;
import xiyu1296.tlias.pojo.Dept;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class deptserviceimp implements  deptservice{

    @Autowired
    private deptmapper Deptmapper;


    @Override
    public List<Dept> list() {
        return Deptmapper.list();
    }

    @Override
    public void deletebyid(Integer id) {
        Deptmapper.deletebyid(id);
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        Deptmapper.add(dept);
    }
}


package xiyu1296.tlias.service;

import org.springframework.stereotype.Service;
import xiyu1296.tlias.pojo.Dept;

import java.util.List;


public interface deptservice {
    List<Dept> list();

    void deletebyid(Integer id);

    void add(Dept dept);
}

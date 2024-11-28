package xiyu1296.tlias.service;

import xiyu1296.tlias.pojo.Emp;
import xiyu1296.tlias.pojo.PageBean;

import java.time.LocalDateTime;
import java.util.List;

public interface empservice {

    PageBean page(Integer startpage, Integer pagesize, String name, Short gender, LocalDateTime starttime, LocalDateTime endtime);

    void delete(List<Integer> ids);

    void save(Emp emp);

    Emp getById(Integer id);

    void update(Emp emp);
}

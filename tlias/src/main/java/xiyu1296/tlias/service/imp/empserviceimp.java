package xiyu1296.tlias.service.imp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xiyu1296.tlias.mapper.empmapper;
import xiyu1296.tlias.pojo.Emp;
import xiyu1296.tlias.pojo.PageBean;
import xiyu1296.tlias.service.empservice;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class empserviceimp implements empservice {

    @Autowired
    private empmapper Empmapper;

    @Override
    public PageBean page(Integer startpage, Integer pagesize, String name, Short gender, LocalDateTime starttime, LocalDateTime endtime) {
        PageHelper.startPage(startpage,pagesize);

        Page<Emp> pg =(Page<Emp>) Empmapper.pageselect( name,gender,starttime,endtime);;

        return new PageBean(pg.getTotal(),pg.getResult());

    }

    @Override
    public void delete(List<Integer> ids) {
        Empmapper.delete(ids);
    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        Empmapper.insert(emp);
    }
}

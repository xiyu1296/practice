package xiyu1296.tlias.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xiyu1296.tlias.mapper.deptlogmapper;
import xiyu1296.tlias.pojo.DeptLog;
import xiyu1296.tlias.service.deptlogservice;

@Service
public class deptlogserviceimp implements deptlogservice {

    @Autowired
    private deptlogmapper deptlogmapper;

    @Override
    public void insert(DeptLog deptlog) {
        deptlogmapper.insert(deptlog);
    }
}

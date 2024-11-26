package xiyu1296.tlias.service;

import xiyu1296.tlias.pojo.PageBean;

import java.time.LocalDateTime;

public interface empservice {

    PageBean page(Integer startpage, Integer pagesize, String name, Short gender, LocalDateTime starttime, LocalDateTime endtime);
}

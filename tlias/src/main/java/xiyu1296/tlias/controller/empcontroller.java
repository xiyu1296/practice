package xiyu1296.tlias.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xiyu1296.tlias.pojo.PageBean;
import xiyu1296.tlias.pojo.Result;
import xiyu1296.tlias.service.imp.empserviceimp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@RequestMapping("/emps")
@RestController
public class empcontroller {
    @Autowired
    private empserviceimp empservice;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDateTime begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDateTime end){
        log.info("分页查询, 参数: {},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
        //调用service分页查询
        PageBean pageBean = empservice.page(page,pageSize,name,gender,begin,end);
        return Result.success(pageBean);

    }
}

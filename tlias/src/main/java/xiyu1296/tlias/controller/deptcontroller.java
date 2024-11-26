package xiyu1296.tlias.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xiyu1296.tlias.pojo.Dept;
import xiyu1296.tlias.pojo.Result;
import xiyu1296.tlias.service.imp.deptserviceimp;

@Slf4j
@RequestMapping("/depts")
@RestController
public class deptcontroller {
    @Autowired
    private deptserviceimp Deptservice;

    @GetMapping
    public Result list(){
        log.info("查询全部部门");
        return Result.success(Deptservice.list());
    }

    @DeleteMapping("/{id}")
    public Result deletebyid(@PathVariable Integer id){
        log.info("删除部门id为{}",id);
        Deptservice.deletebyid(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门{}",dept);
        Deptservice.add(dept);
        return Result.success();
    }
}

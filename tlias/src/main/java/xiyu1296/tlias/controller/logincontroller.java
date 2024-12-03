package xiyu1296.tlias.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.ResolverUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xiyu1296.tlias.pojo.Emp;
import xiyu1296.tlias.pojo.Result;
import xiyu1296.tlias.service.imp.empserviceimp;
import xiyu1296.tlias.utils.jwtutils;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class logincontroller {

    @Autowired
    private empserviceimp empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("username:{},password:{}", emp.getUsername(), emp.getPassword());
        Emp e = empService.getByUsernameAndPassword(emp.getUsername(), emp.getPassword());

        if(e != null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("username", e.getUsername());
            claims.put("Password", e.getPassword());

            String jwt = jwtutils.generateJwt(claims);
            return Result.success(jwt);
        }

        return Result.error("用户名或密码错误");
    }
}

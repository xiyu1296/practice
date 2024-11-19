package fencengjieou_demo.controller.impl;

import fencengjieou_demo.service.impl.userserviceimp;
import fencengjieou_demo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class usercontroller {

    @Autowired
    private userserviceimp userServiceimp;

    @RequestMapping("/list")
    public List<user> List() {
        return userServiceimp.findall();

    }

}
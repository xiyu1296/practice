package fencengjieou_demo.service.impl;

import fencengjieou_demo.dao.impl.userdaoimp;
import fencengjieou_demo.service.interface01.userservice;
import fencengjieou_demo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class userserviceimp implements userservice {

    @Autowired
    private userdaoimp userDaoimp;
    @Override
    public List<user> findall() {

        return userDaoimp.findall().stream().map(line1 -> {
            String[] split = line1.split(",");
            return new user(Integer.parseInt(split[0]), split[1], split[2], split[3], Integer.parseInt(split[4]), LocalDateTime.parse(split[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }).toList();

    }
}

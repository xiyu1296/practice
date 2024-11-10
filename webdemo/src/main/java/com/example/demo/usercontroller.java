package com.example.demo;

import cn.hutool.core.io.IoUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
public class usercontroller {
    @RequestMapping("/list")
    public List<user> List()
    {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());

        List<user> line = lines.stream().map(line1 -> {
            String[] split = line1.split(",");
            return new user(Integer.parseInt(split[0]), split[1], split[2], split[3], Integer.parseInt(split[4]), LocalDateTime.parse(split[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }).toList();

        return line;
    }
}

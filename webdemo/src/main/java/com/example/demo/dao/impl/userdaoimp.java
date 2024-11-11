package com.example.demo.dao.impl;

import cn.hutool.core.io.IoUtil;
import com.example.demo.dao.interface01.userdao;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@Repository
public class userdaoimp implements userdao {
    @Override
    public ArrayList<String> findall() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        return IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
    }
}

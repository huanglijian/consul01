package com.forezp.servicehi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class controller {
    @RequestMapping("/hello")
    public String hello() {
        return "helle consul";
    }

    @RequestMapping("/helloStudent")
    public Student helloStudent() {
        Student s = new Student();
        s.setNumber("001");
        s.setName("张三");
        return s;
    }

    @RequestMapping("/helloStudentList")
    public List<Student> helloStudentList() {
        List<Student> list = new ArrayList<>();
        Student s = new Student();
        s.setNumber("001");
        s.setName("张三");

        Student s2 = new Student();
        s2.setNumber("002");
        s2.setName("李四");

        list.add(s);
        list.add(s2);

        return list;
    }


    @RequestMapping("/helloStudentListMap")
    public Map<String,Object> helloStudentListMap() {
        List<Student> list = new ArrayList<>();
        Student s = new Student();
        s.setNumber("001");
        s.setName("张三");

        Student s2 = new Student();
        s2.setNumber("002");
        s2.setName("李四");

        list.add(s);
        list.add(s2);

        Map<String,Object> map = new HashMap<>();
        map.put("list",list);
        map.put("code","1");
        map.put("mes","成功");

        return map;
    }


}

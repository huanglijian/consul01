package com.forezp.servicehi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
public class callhelloController {

    @Autowired
    private LoadBalancerClient loadBalancer;


    @RequestMapping("/call")
    public String call() {
        ServiceInstance serviceInstance = loadBalancer.choose("service-producer");
        System.out.println("服务地址：" + serviceInstance.getUri());
        System.out.println("服务名称：" + serviceInstance.getServiceId());
        String callServiceResult = new RestTemplate().getForObject(serviceInstance.getUri().toString() + "/hello", String.class);
        System.out.println(callServiceResult);
        return callServiceResult;
    }

    @RequestMapping("/callvo")
    public Student callvo() {
        ServiceInstance serviceInstance = loadBalancer.choose("service-producer");
        System.out.println("服务地址：" + serviceInstance.getUri());
        System.out.println("服务名称：" + serviceInstance.getServiceId());
        String callServiceResult = new RestTemplate().getForObject(serviceInstance.getUri().toString() + "/helloStudent", String.class);
        Student student = new Student();
        student.setName(callServiceResult);
        System.out.println("callServiceResult:"+callServiceResult);
        System.out.println("student:"+student);
        return student;
    }

    @RequestMapping("/callvoST")
    public Student callvoST() {
        ServiceInstance serviceInstance = loadBalancer.choose("service-producer");
        System.out.println("服务地址：" + serviceInstance.getUri());
        System.out.println("服务名称：" + serviceInstance.getServiceId());
        Student student = new RestTemplate().getForObject(serviceInstance.getUri().toString() + "/helloStudent", Student.class);
        System.out.println("student:"+student);
        return student;
    }


    @RequestMapping("/callvoList")
    public List<Student> callvoList() {
        ServiceInstance serviceInstance = loadBalancer.choose("service-producer");
        System.out.println("服务地址：" + serviceInstance.getUri());
        System.out.println("服务名称：" + serviceInstance.getServiceId());
        List<Student> list = new RestTemplate().getForObject(serviceInstance.getUri().toString() + "/helloStudentList", List.class);
        System.out.println("list:"+list);
        return list;
    }

    @RequestMapping("/callvoListMap")
    public Map<String,Object> callvoListMap() {
        ServiceInstance serviceInstance = loadBalancer.choose("service-producer");
        System.out.println("服务地址：" + serviceInstance.getUri());
        System.out.println("服务名称：" + serviceInstance.getServiceId());
        Map<String,Object> map = new RestTemplate().getForObject(serviceInstance.getUri().toString() + "/helloStudentListMap", Map.class);
        System.out.println("map:"+map);
        return map;
    }

}

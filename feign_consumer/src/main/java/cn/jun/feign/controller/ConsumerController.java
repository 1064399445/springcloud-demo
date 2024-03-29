package cn.jun.feign.controller;

import cn.jun.feign.service.HelloService;
import cn.jun.feign.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;


    @RequestMapping(value = "feign-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.hello();
    }

    @RequestMapping(value = "feign-consumer2", method = RequestMethod.GET)
    public String helloConsumer2() {
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append(";\n");
        sb.append(helloService.hello("dada")).append(";\n");
        sb.append(helloService.hello("dada", 20)).append(";\n");
        sb.append(helloService.hello(new User("dada", 22))).append(";\n");
        return sb.toString();
    }


}

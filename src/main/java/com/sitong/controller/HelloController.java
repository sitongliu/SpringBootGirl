package com.sitong.controller;

import com.sitong.properties.GirlProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by LiuSitong on 2017/3/16.
 * 创建第一个SpringBoot程序
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
//    @Value("${cupSize}")
//    private String cupSize;
//    @Value("${age}")
//    private String age;
//    @Value("${content}")
//    private String content;

    @Autowired
    private GirlProperty girlProperty;

    //如果想访问两个都可以访问到 {"/hello","/hi"}
    //    @RequestMapping (value = "/hi/{id}",method = RequestMethod.GET)
    //@RequestMapping (value = "/hi",method = RequestMethod.GET)
    @GetMapping(value = "/hi")  //上一句的简写方法
    //    public String say(@PathVariable("id") Integer id ){
    //    public String say(@RequestParam("id") Integer myID ){  // URL：http://localhost:8080/hello/hi/?id=100
    public String say(@RequestParam(value = "id", required = false, defaultValue = "10") Integer myID) {
        //return " Hello Spring Boot";
        //        return girlProperty.getAge();
        return "ID:" + myID;

    }

}

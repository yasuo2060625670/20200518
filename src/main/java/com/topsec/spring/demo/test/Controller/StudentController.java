package com.topsec.spring.demo.test.Controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：zz
 * @date ：Created in 2020/5/8 9:42
 */
@RestController
public class StudentController {


    @RequestMapping(value = "/{name}/test" ,
            method = RequestMethod.GET)
    public String getName(@PathVariable String name
    ,@RequestParam(value = "password",required = true)String password){
        sout();
        return name+password+"haha";
    }
    @Scheduled(fixedRate = 1000L)
    public void sout(){
        System.out.println("scheduled run once time ");
    }

//   public boolean StudentLogin (@RequestParam(value = "name",required = true)String name,
//                               @RequestParam(value = "password",required = true)String password){
//
//
//        System.out.println(student.test(name, password));
//        return student.test(name, password);
//    }
}

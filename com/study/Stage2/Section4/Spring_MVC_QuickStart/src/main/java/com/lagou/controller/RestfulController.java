package com.lagou.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Administrator
 */

//@Controller
@RestController
@RequestMapping("/restful")
public class RestfulController {

    // 根据ID查询

//    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
//    @ResponseBody

    @GetMapping("/user/{id}")
    public String findById(@PathVariable Integer id) {
        return "findById: " + id;
    }


    // 新增方法

    @PostMapping("/user")
    public String post(){

        return "post";
    }


    // 修改方法

    @PutMapping("/user")
    public String put(){
        return "put";
    }


    // 删除方法

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable Integer id){
        return "delete" + id;
    }




}

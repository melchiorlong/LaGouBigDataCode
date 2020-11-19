package com.lagou.controller;

import com.lagou.domain.Account;
import com.lagou.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

//    查询所有用户

    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Account> list = accountService.findAll();
        model.addAttribute("list", list);
        return "list";
    }

    // 添加用户

    @RequestMapping("/save")
    public String save (Account account){
        accountService.save(account);
        // 跳转到findAll方法 ，重新查询数据库进行数据展示
        return "redirect:/account/findAll";
    }

    // 根据ID查询账户信息 完成账户回显

    @RequestMapping("/findById")
    public String findById (Integer id, Model model){
        Account account = accountService.findById(id);
        // 存入model中
        model.addAttribute("account", account);
        // 视图跳转
        return "update";
    }

    // 根据ID更新账户信息

    @RequestMapping("/update")
    public String update (Account account){
        accountService.update(account);
        // 视图跳转
        return "redirect:/account/findAll";
    }

    // 批量删除

    @RequestMapping("/deleteBatch")
    public String deleteBatch (Integer[] ids){
        accountService.deleteBatch(ids);
        // 视图跳转
        return "redirect:/account/findAll";
    }
}

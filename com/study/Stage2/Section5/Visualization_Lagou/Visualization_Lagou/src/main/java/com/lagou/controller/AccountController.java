package com.lagou.controller;

import com.lagou.common.ResponseCode;
import com.lagou.common.ServerResponse;
import com.lagou.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping("transfer.do")
    @ResponseBody
    public ServerResponse<String> accountTransfer(String inName, String outName, Double money) {
        int status = accountService.tranfer(inName, outName, money);
        if (status == ResponseCode.SUCCESS.getCode()) {
            // 如果执行转账成功
            return ServerResponse.createBySuccessMsg("转账成功");
        } else {
            return ServerResponse.createByErrorMsg("转账失败！");
        }
    }
}

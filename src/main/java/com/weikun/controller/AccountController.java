package com.weikun.controller;

import com.weikun.model.Account;
import com.weikun.model.Category;
import com.weikun.model.CategoryExample;
import com.weikun.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/21.
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Value("${error.login.msg}")
    private String error;
    @Autowired
    private AccountServiceImpl aservice;

    @RequestMapping("/lmain")
    public String lmain(){
        return "shop/login";
    }

    @RequestMapping("/rmain")
    public String rmain(Map map){
        CategoryExample example=new CategoryExample();
        example.createCriteria().andCatidIsNotNull();
        List<Category> clist=aservice.selectByExample(example);
        map.put("clist",clist);
        return "shop/register";
    }
    @RequestMapping("/reg")
    public String reg(@ModelAttribute("account") Account account){
        aservice.insert(account);

        return "shop/login";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(name="username") String username,
                        @RequestParam(name="password") String password,
                        Map map){
        Account a=aservice.login(username,password);
        if(a==null){//没有找到已经注册的用户
            map.put("lerror",error);
            return "shop/login";
        }

        return "shop/main";
    }
}

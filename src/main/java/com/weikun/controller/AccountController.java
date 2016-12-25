package com.weikun.controller;

import com.weikun.model.Account;
import com.weikun.model.Category;
import com.weikun.model.CategoryExample;
import com.weikun.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/12/21.
 */
@Controller
@RequestMapping("/account")
@SessionAttributes(value={"username"})
public class AccountController {
    @Value("${error.login.msg}")
    private String error;


    @Value("${error.register.username}")
    private String error1;

    @Value("${error.register.pwd}")
    private String error2;


    @Value("${error.register.email}")
    private String error3;

    @Value("${error.register.all}")
    private String error4;

    @Autowired
    private AccountServiceImpl aservice;

    @RequestMapping("/lmain")
    public String lmain(){
        return "shop/login";
    }

    @RequestMapping("/rmain")
    public String rmain(Map map){

        queryCategory(map);
        return "shop/register";
    }
    //查询宠物种类
    private void queryCategory(Map map) {
        CategoryExample example=new CategoryExample();
        example.createCriteria().andCatidIsNotNull();
        List<Category> clist=aservice.selectByExample(example);
        map.put("clist",clist);
    }

    @RequestMapping("/reg")
    public String reg(@ModelAttribute("account") Account account,Map map){
        String username=account.getUsername();
        String password=account.getPassword();
        String repassword=account.getRepassword();
        boolean flag=false;

        if(username.trim().equals("")|| username.trim().length()<0){

            map.put("lerror1",error1);
            flag=true;
        }
        if (!password.equals(repassword)){
            map.put("lerror2",error2);
            flag=true;
        }
        String email=account.getEmail();
        String eregex="^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$";
        if (!Pattern.matches(eregex,email)){
            map.put("lerror3",error3);
            flag=true;
        }
        if(flag){
            queryCategory(map);
            return "shop/register";
        }

        if(aservice.insert(account)){
            return "shop/login";
        }else{
            queryCategory(map);
            map.put("lerror4",error4);
            return "shop/register";
        }



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
        map.put("username",a.getUsername());
        return "shop/main";
    }
}

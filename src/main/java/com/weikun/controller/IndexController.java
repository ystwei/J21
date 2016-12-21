package com.weikun.controller;

import com.weikun.service.AccountServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/12/21.
 */
@Controller
public class IndexController {


    @RequestMapping("/")
    public String index(){
        return "index";
    }


}

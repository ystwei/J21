package com.weikun.controller;

import com.weikun.service.PetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/25.
 */
@Controller
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetServiceImpl pservice;

    @RequestMapping("/query/cat/{catid}/pro/{proid}/item/{itemid}")
    public String query(@PathVariable(value="catid") String catid,
                        @PathVariable(value="proid") String proid,
                        @PathVariable(value="itemid") String itemid,
                        Map map){
        List list=null;
        catid=catid.equals("null")?"":catid;
        proid=proid.equals("null")?"":proid;
        itemid=itemid.equals("null")?"":itemid;
        if(catid!="" ||catid.length()>0){
            list=pservice.queryPet5Product(catid,proid,itemid);
            map.put("plist",list);
            return "shop/product";
        }else if(proid!="" ||proid.length()>0){
            list=pservice.queryPet5Items(catid,proid,itemid);
            map.put("plist",list);
            return "shop/items";
        }else{
            list=pservice.queryPet5Items(catid,proid,itemid);
            map.put("plist",list);
            return "shop/item";
        }



    }
}

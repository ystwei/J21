package com.weikun.controller;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message_1_0;
import com.weikun.model.Cart;
import com.weikun.model.Orders;
import com.weikun.service.CartServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/25.
 */
@Controller
@RequestMapping("/cat")
public class CartController {
    @Autowired
    private CartServiceImpl cservice;
    @RequestMapping("/checkout/oid/{oid}/total/{total}")
    public String checkout(@PathVariable(value="oid") String oid,
                           @PathVariable(value="total") String total){
        Orders orders=new Orders();
        orders.setOrderid(Integer.parseInt(oid));
        orders.setTotalprice(new BigDecimal(total));
        orders.setOrderdate(new Date());
        cservice.updateByPrimaryKey(orders);
        return "redirect:/";
    }


    @RequestMapping("/update")
    public String update(String[] oid,
                         String [] iid,
                         String [] qty , Map map){

        for(int i=0;i<oid.length;i++){
            Map m=new HashMap();
            m.put("in_orderid",oid[i]);
            m.put("in_itemid",iid[i]);
            m.put("in_qty",qty[i]);
            cservice.updateCart(m);
        }



        List<Cart> list=cservice.queryCart(oid[0]);
        map.put("clist",list);
        return "/shop/cart";
    }

    @RequestMapping("/del/itemid/{itemid}/oid/{oid}")
    public String del(@PathVariable(value="itemid") String itemid,
                      @PathVariable(value="oid") String oid,
                      Map map){

        cservice.deleteByPrimaryKey(oid,itemid);

        List<Cart> list=cservice.queryCart(oid);
        map.put("clist",list);
        return "/shop/cart";
    }
    @RequestMapping("/add/qu/{qu}/itemid/{itemid}")
    public String add(@PathVariable(value="itemid") String catid,
                      @PathVariable(value="qu") String qu,
                      Map map){
        Map<String,String> m=new HashMap<String,String>();
        m.put("in_itemid",catid);
        m.put("in_quantity",qu);
        m.put("out_oid","");
        cservice.addCart(m);

        List<Cart> list=cservice.queryCart(m.get("out_oid"));
        map.put("clist",list);
        return "/shop/cart";
    }
}

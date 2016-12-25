package com.weikun.service;

import com.weikun.mapper.CartMapper;
import com.weikun.mapper.OrdersMapper;
import com.weikun.model.Cart;
import com.weikun.model.CartKey;
import com.weikun.model.Orders;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/25.
 */
@Service
public class CartServiceImpl {


    @Autowired
    private CartMapper cdao;

    @Autowired
    private OrdersMapper odao;

    public void addCart(Map map ){
        cdao.addCart(map);
    }

    public List<Cart> queryCart(@Param("in_itemid") String in_orderid){
        return cdao.queryCart(in_orderid);
    }
    public int deleteByPrimaryKey(String orderid,String itemid){
        CartKey cartkey=new CartKey();
        cartkey.setOrderid(Integer.parseInt(orderid));
        cartkey.setItemid(itemid);
        return cdao.deleteByPrimaryKey(cartkey);
    }
    public void updateCart(Map map){
        cdao.updateCart(map);
    }
    public  int updateByPrimaryKey(Orders record){
        return odao.updateByPrimaryKey(record);

    }
}

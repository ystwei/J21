package com.weikun.service;

import com.weikun.mapper.PetMapper;
import com.weikun.model.Item;
import com.weikun.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/12/25.
 */
@Service
public class PetServiceImpl {

    @Autowired
    private PetMapper pdao;

    public List<Product> queryPet5Product(String catid,String proid,String itemid){
        return pdao.queryPet5Product(catid,proid,itemid);
    }

    public List<Item> queryPet5Items(String catid, String proid, String itemid){
        return pdao.queryPet5Items(catid,proid,itemid);
    }
}

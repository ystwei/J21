package com.weikun.service;

import com.weikun.mapper.AcoountMapper;
import com.weikun.mapper.CategoryMapper;
import com.weikun.mapper.ProfileMapper;
import com.weikun.model.Account;
import com.weikun.model.Category;
import com.weikun.model.CategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/12/21.
 */
@Service
public class AccountServiceImpl {
    @Autowired
    private AcoountMapper adao;

    @Autowired
    private CategoryMapper cdao;

    @Autowired
    private ProfileMapper pdao;

    public Account login(String username, String password){
        return adao.login(username,password);
    }

    public List<Category> selectByExample(CategoryExample example){
        return cdao.selectByExample(example);
    }

    public boolean insert(Account record){
        record.getProfile().setUsername(record.getUsername());//设置profile的主键
        return adao.insert(record)>0 &&pdao.insert(record.getProfile())>0;
    }
}

package com.weikun.mapper;

import com.weikun.model.Cart;
import com.weikun.model.CartExample;
import com.weikun.model.CartKey;
import java.util.List;
import java.util.Map;

import com.weikun.model.Item;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.type.JdbcType;

public interface CartMapper {



    //存储过程
    @Insert(value= "{ CALL  addCart6( " +
            "#{in_itemid, mode=IN, jdbcType=VARCHAR}," +
            "#{in_quantity, mode=IN, jdbcType=VARCHAR}," +
            "#{out_oid, mode=OUT, jdbcType=VARCHAR})}")
    @Options(statementType = StatementType.CALLABLE)
    public void addCart(Map map);


    @Update(value= "{ CALL  updateCart6( " +
            "#{in_orderid, mode=IN, jdbcType=VARCHAR}," +
            "#{in_itemid, mode=IN, jdbcType=VARCHAR}," +
            "#{in_qty, mode=IN, jdbcType=INTEGER})}")
    @Options(statementType = StatementType.CALLABLE)
    public void updateCart(Map map);

    @Select(value= "{ CALL  queryCart6( " +
            "#{in_orderid, mode=IN, jdbcType=VARCHAR}"+
            ")}")
    @Results({
            @Result(column="orderid", property="orderid", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="itemid", property="itemid", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="quantity", property="quantity", jdbcType=JdbcType.INTEGER),
            @Result(column="itemid", property="item",
                one=@One(select="com.weikun.mapper.ItemMapper.findItemByItemid"))
    })
    @Options(statementType = StatementType.CALLABLE)
    List<Cart> queryCart(@Param("in_orderid") String in_orderid);

    @SelectProvider(type=CartSqlProvider.class, method="countByExample")
    long countByExample(CartExample example);

    @DeleteProvider(type=CartSqlProvider.class, method="deleteByExample")
    int deleteByExample(CartExample example);

    @Delete({
        "delete from cart",
        "where orderid = #{orderid,jdbcType=INTEGER}",
          "and itemid = #{itemid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(CartKey key);

    @Insert({
        "insert into cart (orderid, itemid, ",
        "quantity)",
        "values (#{orderid,jdbcType=INTEGER}, #{itemid,jdbcType=VARCHAR}, ",
        "#{quantity,jdbcType=INTEGER})"
    })
    int insert(Cart record);

    @InsertProvider(type=CartSqlProvider.class, method="insertSelective")
    int insertSelective(Cart record);

    @SelectProvider(type=CartSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="orderid", property="orderid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="itemid", property="itemid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="quantity", property="quantity", jdbcType=JdbcType.INTEGER)
    })
    List<Cart> selectByExample(CartExample example);

    @Select({
        "select",
        "orderid, itemid, quantity",
        "from cart",
        "where orderid = #{orderid,jdbcType=INTEGER}",
          "and itemid = #{itemid,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="orderid", property="orderid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="itemid", property="itemid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="quantity", property="quantity", jdbcType=JdbcType.INTEGER)
    })
    Cart selectByPrimaryKey(CartKey key);

    @UpdateProvider(type=CartSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Cart record, @Param("example") CartExample example);

    @UpdateProvider(type=CartSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Cart record, @Param("example") CartExample example);

    @UpdateProvider(type=CartSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Cart record);

    @Update({
        "update cart",
        "set quantity = #{quantity,jdbcType=INTEGER}",
        "where orderid = #{orderid,jdbcType=INTEGER}",
          "and itemid = #{itemid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Cart record);
}
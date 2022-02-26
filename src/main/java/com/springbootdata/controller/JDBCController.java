package com.springbootdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author longxiang
 * @data 2022/2/8 23:00
 */
@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @GetMapping("/dishList")
    public List<Map<String,Object>> getDishList(){
        String sql="select * from dish";
        List<Map<String, Object>> dish_list = jdbcTemplate.queryForList(sql);
        return dish_list;
    }

    @GetMapping("/addOrder")
    public String addOrder(){
        String sql="insert into hotpot.`order`" +
                "(order_id, order_price, user_id, status)" +
                " values (?,?,?,?)";
        Object[] objects=new Object[4];
        objects[0]="2";
        objects[1]=2333;
        objects[2]="1";
        objects[3]=0;
        jdbcTemplate.update(sql,objects);
        return "add_ok";
    }

//    此類的查詢為updateOrder/id
    @GetMapping("/updateOrder/{id}")
    public String updateOrder(@PathVariable("id") Integer id){
        String sql="update hotpot.`order` set order_price=?,status=? where order_id= "+id;

        Object[] objects=new Object[2];
        objects[0]="100";
        objects[1]=0;
        jdbcTemplate.update(sql,objects);
        return "update_ok";
    }

    @GetMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable("id") Integer id){
        String sql="delete from hotpot.`order` where order_id=?";
        jdbcTemplate.update(sql,id);
        return "delete_ok";
    }

}

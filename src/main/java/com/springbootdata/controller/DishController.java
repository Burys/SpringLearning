package com.springbootdata.controller;

import com.springbootdata.mapper.DishMapper;
import com.springbootdata.pojo.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author longxiang
 * @data 2022/2/27 22:45
 */

@RestController
public class DishController {

    @Autowired
    private DishMapper dishMapper;

    @GetMapping("/queryDishList")
    public List<Dish> queryDishList(){
        List<Dish> dishes = dishMapper.queryDishList();
        for(Dish dish:dishes){
            System.out.println(dish);
        }
        return dishes;
    }

    @GetMapping("/queryDishById")
    public Dish queryDishById(){
        Dish dish=dishMapper.queryDishById(3);
        return dish;
    }

    @GetMapping("/addDish")
    public int addDish(){
        Dish dish = new Dish();
        dish.setDish_id("4");
        dish.setDish_name("鱼丸");
        dish.setDish_pic("1");
        dish.setSort_id("3");
        dishMapper.addDish(dish);
        return 1;
    }

    @GetMapping("/updateDish")
    public int updateDIsh(){
        Dish dish=new Dish();
        dish.setDish_id("4");
        dish.setDish_pic("100");
        dish.setSort_id("7");
        dishMapper.updateDish(dish);
        return 2;
    }

    @GetMapping("/deleteDish")
    public int deleteDish(){
        dishMapper.deleteDish(4);
        return 3;
    }
}

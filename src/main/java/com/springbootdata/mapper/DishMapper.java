package com.springbootdata.mapper;

import com.springbootdata.pojo.Dish;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author longxiang
 * @data 2022/2/27 17:10
 */
@Mapper
@Repository
public interface DishMapper {
    List<Dish> queryDishList();

    Dish queryDishById(int id);

    int addDish(Dish dish);

    int updateDish(Dish dish);

    int deleteDish(int id);
}

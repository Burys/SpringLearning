package com.springbootdata.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author longxiang
 * @data 2022/2/27 22:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish {

    private String dish_id;
    private String dish_name;
    private String dish_pic;
    private String sort_id;
    private int dish_price;
    private int format;
    private int remain_num;
    private int sale_num;
    private int collection;
    private int status;
    private int is_delete;
}

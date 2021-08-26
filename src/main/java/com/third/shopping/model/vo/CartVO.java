package com.third.shopping.model.vo;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Alias("CartVO")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CartVO {
    private int cart_idx;
    private int mem_idx;
    private int item_idx;
    private int itemcount;

    /* 고치는 부분 */
    private String name;
    private int price;
    private List<String> src;

}

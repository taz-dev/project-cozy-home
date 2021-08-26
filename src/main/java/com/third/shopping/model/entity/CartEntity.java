package com.third.shopping.model.entity;


import com.third.shopping.model.vo.CartVO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Alias("CartEntity")
@Getter
@Setter
@Builder
public class CartEntity {

    private int cart_idx;
    private int mem_idx;
    private int item_idx;
    private int itemcount;

    public CartVO voChange() {

        CartVO cartVO = new CartVO();
        cartVO.setCart_idx(cart_idx);
        cartVO.setMem_idx(mem_idx);
        cartVO.setItem_idx(item_idx);
        cartVO.setItemcount(this.itemcount);

        return cartVO;
    }
}

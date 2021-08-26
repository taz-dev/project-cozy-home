package com.third.shopping.controller;

import com.third.shopping.model.vo.CartVO;
import com.third.shopping.model.vo.ItemVO;
import com.third.shopping.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin
@RestController
public class CartController {

    @Autowired
    CartService cartService;

    /* 장바구니에 아이템 추가 */
    @PostMapping("/cart/insertCart")
    public int insertCart(@RequestBody CartVO vo, Principal principal) {
        return cartService.insertCart(vo, principal);
    }

    /* count 증가 */
    @PostMapping("/cart/upCount")
    public int upCount(@RequestBody CartVO vo) {
        return cartService.upCount(vo);
    }

    /* count 감소 */
    @PostMapping("/cart/downCount")
    public int downCount(@RequestBody CartVO vo) {
        return cartService.downCount(vo);
    }

    /* 장바구니 아이템 삭제 */
    @PostMapping("/cart/deleteCartItem")
    public int deleteCartItem(@RequestBody CartVO vo){
        return cartService.deleteCartItem(vo);
    }

    /* 장바구니 비우기 */
    @PostMapping("/cart/deleteAll")
    public int deleteAll(@RequestBody CartVO vo) {
        return cartService.deleteAll(vo);
    }

    @GetMapping("/cart/cartList")
    public CartVO selectOneCart(ItemVO itemVO, int cart_idx) {
        return cartService.selectOneCart(itemVO, cart_idx);
    }

}

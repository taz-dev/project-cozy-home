package com.third.shopping.controller;

import com.third.shopping.model.entity.ItemEntity;
import com.third.shopping.model.vo.ItemListPageVO;
import com.third.shopping.model.vo.ItemVO;
import com.third.shopping.model.vo.UpdateItemVO;
import com.third.shopping.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ItemController {

    @Autowired
    ItemService itemService;


    /*  POST   *//*  POST   *//*  POST   *//*  POST   *//*  POST   *//*  POST   */
    @PostMapping("/item/insertItem") // 아이템등록
    public int insertItem(@RequestBody ItemVO vo){
        return itemService.insertItem(vo);
    }
    /*  POST   *//*  POST   *//*  POST   *//*  POST   *//*  POST   *//*  POST   */
    /*  GET   *//*  GET   *//*  GET   *//*  GET   *//*  GET   *//*  GET   */
    @GetMapping("/item/selectOne") //<!-- 1 아이템하나 정보찾기 -->//
    public ItemVO selectOne(int item_idx) {
        return itemService.selectOne(item_idx);
    }
    @GetMapping("/item/selectList") //  아이템리스트 다가져오기
    public List<ItemEntity> selectList(){
        return itemService.selectList();
    }
    @GetMapping("/item/itemPopList") //리스트
    public List<ItemVO> itemPopList(){ //페이징처리하기()
        return itemService.itemPopList();
    }



    @GetMapping("/item/itemListPage") //치트키
    public List<ItemListPageVO> itemListPage(int first_idx) {
        return itemService.itemListPage(first_idx);
    }
    /*  GET   *//*  GET   *//*  GET   *//*  GET   *//*  GET   *//*  GET   */
    /*  PATCH   *//*  PATCH   *//*  PATCH   *//*  PATCH   *//*  PATCH   */
    @PatchMapping("/item/updateItem") //수정 업데이트문이 잘안되서 인설트후 삭제과정
    public int updateItem(@RequestBody UpdateItemVO vo) {
        return itemService.updateItem(vo);
    }
    /*  PATCH   *//*  PATCH   *//*  PATCH   *//*  PATCH   *//*  PATCH   */
    /*  DELETE   *//*  DELETE   *//*  DELETE   *//*  DELETE   *//*  DELETE   */
    @DeleteMapping("/item/delete") //삭제
    public int deleteItem(int idx) {
        return itemService.deleteItem(idx);
    }
    /*  DELETE   *//*  DELETE   *//*  DELETE   *//*  DELETE   *//*  DELETE   */


}

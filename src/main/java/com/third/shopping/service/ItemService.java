package com.third.shopping.service;

import com.third.shopping.controller.ItemController;
import com.third.shopping.dao.ItemDAO;
import com.third.shopping.dao.SecondDAO;
import com.third.shopping.model.entity.ItemEntity;
import com.third.shopping.model.vo.ItemListPageVO;
import com.third.shopping.model.vo.ItemVO;
import com.third.shopping.model.vo.SecondVO;
import com.third.shopping.model.vo.UpdateItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemDAO itemDAO;
    @Autowired
    SecondDAO secondDAO;

    public int insertItem(ItemVO vo){
        return itemDAO.insertItem(vo);
    }

    public ItemVO selectOne(int item_idx) {
        ItemEntity entity = itemDAO.selectOne(item_idx);
        ItemVO itemVO = entity.voChange();
        itemVO.setSrc(selectSrc(item_idx));
        return itemVO;
    }

    public List<ItemEntity> selectList() {
        return itemDAO.selectList();
    }

    public int updateItem(UpdateItemVO vo) {

        ItemEntity itemEntity = itemDAO.selectOne(vo.getItemIdx());
        itemDAO.deleteItem(vo.getItemIdx());
        itemEntity.setContent(vo.getContent());
        itemEntity.setName(vo.getName());
        itemEntity.setPrice(vo.getPrice());
        return itemDAO.updateItem(itemEntity);
    }

    public List<ItemVO> itemPopList() {
        List<ItemEntity> list = itemDAO.itemPopList();
        List<ItemVO> responseList = ItemService.Util.changeListVO(list);

        for (int i = 0 ; i<responseList.size();i++){
        ItemVO itemVO = responseList.get(i);
        List<String> src = new ArrayList<>();
        src.add(itemDAO.selectSrcOne(itemVO.getItem_idx()));
        itemVO.setSrc(src);


        }

        return responseList;
    }


    public List<String> selectSrc(int item_idx){

        return itemDAO.selectSrc(item_idx);
    }

    public List<ItemEntity> selectSecondList(int second_idx) {
        return itemDAO.selectSecondList(second_idx);
    }

    public List<ItemListPageVO> itemListPage(int first_idx){

        List<ItemListPageVO> returnlist = new ArrayList<>();
        List<SecondVO> secondList =secondDAO.secondList(first_idx);
        
        for(int i = 0;i<secondList.size();i++ ) {
            ItemListPageVO itemListPageVO = new ItemListPageVO();
            itemListPageVO.setSecondVO(secondList.get(i));
            itemListPageVO.setItemListVO(ItemService.Util.changeListVO(itemDAO.selectSecondList(
                    secondList.get(i).getSecond_idx())));
            for (int j=0;j<itemListPageVO.getItemListVO().size();j++){
                List<String> src = new ArrayList<>();
                src.add(itemDAO.selectSrcOne(itemListPageVO.getItemListVO().get(j).getItem_idx()));
                itemListPageVO.getItemListVO().get(j).setSrc(src);
            }
            returnlist.add(itemListPageVO);
        }

        return returnlist;
    }

    public int deleteItem(int idx) {
        return itemDAO.deleteItem(idx);
    }
    static class Util{
        static public List<ItemVO> changeListVO(List<ItemEntity> list){

            List<ItemVO> listVO = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {


                listVO.add(list.get(i).voChange());
            }
            return listVO;
        }
    }
}

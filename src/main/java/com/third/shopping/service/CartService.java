package com.third.shopping.service;

import com.third.shopping.dao.CartDAO;
import com.third.shopping.dao.ItemDAO;
import com.third.shopping.model.entity.CartEntity;
import com.third.shopping.model.entity.MemberEntity;
import com.third.shopping.model.vo.CartVO;
import com.third.shopping.model.vo.ItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class CartService {

    @Autowired
    MemberService memberService;
    @Autowired
    CartDAO cartDAO;
    @Autowired
    ItemDAO itemDAO;

    public int insertCart(CartVO vo, Principal principal) {

        MemberEntity memberEntity = memberService.findPrincipal(principal);
        vo.setMem_idx(memberEntity.getMem_idx());
        return cartDAO.insertCart(vo);

    }

    public int upCount(CartVO vo) {
        return cartDAO.upCount(vo);
    }

    public int downCount(CartVO vo) {
        return cartDAO.downCount(vo);
    }

    public int deleteCartItem(CartVO vo) {
        return cartDAO.deleteCartItem(vo);
    }

    public int deleteAll(CartVO vo) {
        return cartDAO.deleteAll(vo);
    }

    /* 고치는 부분 */
/*    public List<CartListPageVO> cartListTest(CartListPageVO vo) {

        List<CartListPageVO> cList = cartDAO.cartListTest(vo);
        List<ItemVO> iList = itemDAO.

        for (int i = 0; i < cList.size(); i++) {
            CartListPageVO clvo = new CartListPageVO();

            System.out.println("cList 사이즈 : " + cList.size());
            System.out.println("cList get(i) : " + cList.get(i));
        }
        return cList;
    }*/

/*    public List<String> selectSrc(int item_idx) {
        return itemDAO.selectSrc(item_idx);
    }
    public List<String>  selectName(int item_idx) {
        return itemDAO.selectName(item_idx);
    }
    public List<String>  selectPrice(int item_idx) {
        return itemDAO.selectPrice(item_idx);
    }*/

    public CartVO selectOneCart(ItemVO itemVO, int cart_idx) {
        CartEntity entity = cartDAO.selectOneCart(cart_idx);
        CartVO vo = entity.voChange();
        vo.setName(itemVO.getName());
        vo.setPrice(itemVO.getPrice());
        vo.setSrc(itemVO.getSrc());
        return vo;
    }

}

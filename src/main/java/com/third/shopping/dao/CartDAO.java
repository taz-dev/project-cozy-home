package com.third.shopping.dao;

import com.third.shopping.model.entity.CartEntity;
import com.third.shopping.model.vo.CartVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("cartDao")
public class CartDAO {

    @Autowired
    SqlSession sqlSession;

    public int cartInsertItem(CartVO cartVO1) {

        return sqlSession.insert("c.cartInsertItem", cartVO1);
    }


    /* 장바구니 목록*/
/*    public List<CartVO> cartList() {
        return sqlSession.selectList("c.cartList");
    }*/

    /* 장바구니에 아이템 추가 */
    public int insertCart(CartVO vo) {
        return sqlSession.insert("c.insertCart", vo);
    }

    /* itemcount 1씩 증가 */
    public int upCount(CartVO vo){
        return sqlSession.update("c.upCount", vo);
    }

    /* itemcount 감소 */
    public int downCount(CartVO vo) {
        return sqlSession.update("c.downCount", vo);
    }

    /* 장바구니에 아이템 삭제 */
    public int deleteCartItem(CartVO vo) {
        return sqlSession.delete("c.deleteCartItem", vo);
    }

    /* 장바구니 비우기 */
    public int deleteAll(CartVO vo) {
        return sqlSession.delete("c.deleteAll", vo);
    }

    /* src 가져오기 */
/*    public String selectSrc(int item_idx) {
        return sqlSession.selectOne("c.selectSrc", item_idx);
    }*/

    public CartEntity selectOneCart(int cart_idx) {
        return sqlSession.selectOne("c.selectOneCart", cart_idx);
    }

    /* item 가져오기 */



}

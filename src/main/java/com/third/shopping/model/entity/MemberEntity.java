package com.third.shopping.model.entity;

import com.third.shopping.model.vo.CartVO;
import com.third.shopping.model.vo.InsertVO;
import com.third.shopping.model.vo.MemberVO;
import lombok.*;
import org.apache.ibatis.type.Alias;

@Alias("MemberEntity")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {

    private int mem_idx;
    private String id;
    private String pw;
    private String name;
    private String addr;
    private String tel;
    private String isAdmin;
    private String addr_detail;


    public InsertVO voChange() {

        InsertVO insertVO = new InsertVO();
        insertVO.setAddr(this.addr);
        insertVO.setId(this.id);
        insertVO.setMem_idx(this.mem_idx);
        insertVO.setName(this.name);
        insertVO.setPw(this.pw);
        insertVO.setTel(this.tel);
        insertVO.setAddr_detail(this.addr_detail);
        return insertVO;

    }
    public MemberVO voChange2() {
        MemberVO memberVO = new MemberVO();
        memberVO.setAddr(this.addr);
        memberVO.setId(this.id);
        memberVO.setMem_idx(this.mem_idx);
        memberVO.setName(this.name);
        memberVO.setTel(this.tel);
        memberVO.setAddr_detail(this.addr_detail);
        return memberVO;

    }
    public CartVO voChange3() {
        CartVO cartVO = new CartVO();
        cartVO.setMem_idx(this.mem_idx);
        return cartVO;

    }

}
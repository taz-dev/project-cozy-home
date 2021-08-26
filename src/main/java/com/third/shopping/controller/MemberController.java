package com.third.shopping.controller;

import com.third.shopping.dao.MemberDAO;
import com.third.shopping.model.entity.MemberEntity;
import com.third.shopping.model.vo.InsertVO;
import com.third.shopping.model.vo.MemberVO;
import com.third.shopping.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberDAO memberDao;

    @GetMapping("/member/selectOneLogo")
    public MemberVO selectoneMember(MemberEntity member, Principal principal){
        return memberService.selectoneMember(member , principal);
    }

    @PostMapping("/member/registerMember")
    public int registerMember(@RequestBody InsertVO vo){
        return memberService.postRegister(vo);
    }

    @GetMapping("/idCheck") //결과가 1이면 중복입니다 말해줘야댐
    public int idCheckMember(String id){
        return memberService.idCheckMember(id);
    }

    @PatchMapping("/member/updateMember")
    public int updateMember(@RequestBody InsertVO vo){
        return memberService.updateMember(vo);
    }

    @DeleteMapping("/member/delete")
    public int deleteMember(int idx){
        return memberService.memberDelete(idx);
    }

    @GetMapping("/member/test")
    public List<InsertVO> list(){
        return memberDao.testList();
    }




}
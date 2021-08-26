package com.third.shopping.dao;

import com.third.shopping.model.entity.MemberEntity;
import com.third.shopping.model.vo.InsertVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("memberDao")
public class MemberDAO {

    @Autowired
    SqlSession sqlsession;

    //회원가입
    public int register(InsertVO vo) {

        return sqlsession.insert("m.register", vo);
    }

    //MemberEntity
    public MemberEntity selectMember(int idx) {

        return sqlsession.selectOne("m.selectMember" ,idx);
    }

    //회원정보수정
    public int updateMember(MemberEntity memberEntity) {

        return sqlsession.insert("m.updateMember" , memberEntity);
    }

    //회원정보삭제
    public int memberDelete(int idx) {

        return sqlsession.delete("m.memberDelete", idx);
    }

    public List<InsertVO> testList() {
        return sqlsession.selectList("m.test");
    }

    public MemberEntity authMember(String id) {
        return sqlsession.selectOne("m.authMember",id);
    }

    public int idCheckMember(String id) {

        return sqlsession.selectOne("m.idCheckMember",id);
    }


}
package com.third.shopping.dao;

import com.third.shopping.model.vo.LoginVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("loginDao")
public class LoginDAO {

    @Autowired
    SqlSession sqlsession;

    // 로그인
    public LoginVO login(LoginVO vo) {

        return sqlsession.selectOne("m.login", vo);
    }

}


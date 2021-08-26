package com.third.shopping.dao;

import com.third.shopping.model.vo.FirstVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FirstDAO {
	
	@Autowired
	SqlSession sqlSession;

	public List<FirstVO> firstList() {
		return sqlSession.selectList("i.firstList");
	}


}

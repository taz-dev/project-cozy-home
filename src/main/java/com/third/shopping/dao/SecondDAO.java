package com.third.shopping.dao;

import com.third.shopping.model.vo.ItemVO;
import com.third.shopping.model.vo.SecondVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SecondDAO {

	@Autowired
	SqlSession sqlSession;

	public List<SecondVO> secondList(int first_idx) {
		return sqlSession.selectList("i.secondList", first_idx);
	}

	public List<ItemVO> secondItemlist(int second_Idx) {
		return sqlSession.selectList("i.seconditemList", second_Idx);
	}
	 
	

}

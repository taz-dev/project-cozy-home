package com.third.shopping.controller;

import com.third.shopping.dao.SecondDAO;
import com.third.shopping.model.vo.ItemVO;
import com.third.shopping.model.vo.SecondVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin
@RestController
public class SecondController {

	@Autowired
	SecondDAO secondDAO;
	/*  GET   *//*  GET   *//*  GET   *//*  GET   *//*  GET   *//*  GET   */
	@GetMapping("/secondlist") //홈화면 다음 리스트
	public List<SecondVO> secondCategory(int first_idx){
		

		return secondDAO.secondList(first_idx);
	}

	@GetMapping("/seconditemlist")
	public List<ItemVO> secondItemList(int second_Idx){
		System.out.println(second_Idx);
		return secondDAO.secondItemlist(second_Idx);
	}
	/*  GET   *//*  GET   *//*  GET   *//*  GET   *//*  GET   *//*  GET   */
	
	
}
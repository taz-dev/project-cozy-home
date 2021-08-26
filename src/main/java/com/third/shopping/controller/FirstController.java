package com.third.shopping.controller;

import com.third.shopping.dao.FirstDAO;
import com.third.shopping.model.vo.FirstVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
public class FirstController {
	
	@Autowired
	FirstDAO firstDAO;


	/*  GET   *//*  GET   *//*  GET   *//*  GET   *//*  GET   *//*  GET   */

	@GetMapping("/list")
	public List<FirstVO> firstCategory(){
		
		return firstDAO.firstList();

	}

	/*  GET   *//*  GET   *//*  GET   *//*  GET   *//*  GET   *//*  GET   */
}

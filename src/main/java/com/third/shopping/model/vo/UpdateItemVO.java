package com.third.shopping.model.vo;


import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Alias("UpdateItemVO")
@Setter
@Getter
public class UpdateItemVO{

	private int itemIdx;
	private String name;
	private String content;
	private int price;
	

	
}

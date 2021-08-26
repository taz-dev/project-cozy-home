package com.third.shopping.model.vo;


import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;


@Alias("FirstVO")
@Getter
@Setter
public class FirstVO {

	private
	int first_idx;
	private String first_name;
	private String src;
	


	
}

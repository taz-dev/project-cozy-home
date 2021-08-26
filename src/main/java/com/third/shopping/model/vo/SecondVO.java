package com.third.shopping.model.vo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Alias("SecondVO")
@Setter
@Getter
@ToString
public class SecondVO {
	private int first_idx;
	private int second_idx;
	private String second_name;


}

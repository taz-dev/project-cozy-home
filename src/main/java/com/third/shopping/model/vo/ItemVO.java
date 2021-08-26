package com.third.shopping.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.util.List;


@Alias("ItemVO")
@Getter
@Setter
@ToString
public class ItemVO{
	
	private int item_idx;
	private int second_idx;
	private String name;
	private String content;
	private int price;
	private int sell_count;
	private List<String> src;

}

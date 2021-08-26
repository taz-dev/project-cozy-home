package com.third.shopping.model.entity;

import com.third.shopping.model.vo.ItemVO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;


@Alias("ItemEntity")
@Getter
@Setter
@ToString
@Builder
public class ItemEntity {

	private int item_idx;
	private int second_idx;
	private String name;
	private String content;
	private int price;
	private int sell_count;
	private Timestamp CREATE_DATE;
	private Timestamp UPDATE_DATE;

	public ItemVO voChange(){
			
		ItemVO itemVO = new ItemVO();
		itemVO.setItem_idx(item_idx);
		itemVO.setContent(this.content);
		itemVO.setName(this.name);
		itemVO.setPrice(this.price);
		itemVO.setSecond_idx(this.second_idx);
		itemVO.setSell_count(this.sell_count);
		return itemVO;
	}

}

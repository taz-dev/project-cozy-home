package com.third.shopping.model.vo;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Alias("ItemListPageVO")
@Setter
@Getter
public class ItemListPageVO {

	private SecondVO secondVO;
	private List<ItemVO> itemListVO;


}

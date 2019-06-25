package com.pinyougou.search.service;

import java.util.List;
import java.util.Map;

public interface ItemSearchService {

	/**
	 * 搜索方法
	 * 
	 * @param searchMap
	 * @return
	 */
	public Map search(Map searchMap);

	/**
	 * 导入数据
	 * 
	 * @param list
	 */
	public void importList(List list);

	/**
	 * 删除数据
	 * 
	 * @param ids
	 */
	public void deleteByGoodsIds(List goodsIdList);

}

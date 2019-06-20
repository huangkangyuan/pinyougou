package com.pinyougou.page.service;

public interface ItemPageService {

	/**
	 * 生成商品详细页
	 * 
	 * @param goodsId
	 * @return
	 */
	public boolean genItemHtml(Long goodsId);
	public boolean deleteItemHtml(Long[] goodsIds);

}

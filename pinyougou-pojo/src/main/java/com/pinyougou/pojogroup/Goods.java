package com.pinyougou.pojogroup;

import java.io.Serializable;

import java.util.List;

import com.pinyougou.pojo.TbGoods;
import com.pinyougou.pojo.TbGoodsDesc;
import com.pinyougou.pojo.TbItem;

/**
 * 商品组合实体类
 * 
 * @author Administrator
 *
 */
public class Goods implements Serializable {

	private TbGoods goods;// 商品SPU基本信息
	private TbGoodsDesc goodsDesc; // 商品SPU扩展信息
	private List<TbItem> itemList;// SKU列表

	public TbGoods getGoods() {
		return goods;
	}

	public void setGoods(TbGoods goods) {
		this.goods = goods;
	}

	public TbGoodsDesc getGoodsDesc() {
		return goodsDesc;
	}

	public void setGoodsDesc(TbGoodsDesc goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	public List<TbItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<TbItem> itemList) {
		this.itemList = itemList;
	}

}

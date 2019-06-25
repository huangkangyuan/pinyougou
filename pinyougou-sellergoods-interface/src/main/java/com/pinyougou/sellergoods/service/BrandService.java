package com.pinyougou.sellergoods.service;

import java.util.List;
import java.util.Map;

import com.pinyougou.pojo.TbBrand;

import entity.PageResult;

/**
 * 品牌接口
 * @author Administrator
 *
 */
public interface BrandService {

	public List<TbBrand> findAll();
	
	public PageResult findByPage(int pageNum,int pageSize);
	
	public void add(TbBrand brand);
	
	public TbBrand findOneById(Long id);
	
	public void update(TbBrand brand);
	
	public void deleteByIds(Long[] ids);
	
	public PageResult findByPage(TbBrand tbBrand,int pageNum,int pageSize);

	public List<Map> selectOptionList();
	
	public int findByName(String BrandName);
	
}

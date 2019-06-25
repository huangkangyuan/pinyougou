package com.pinyougou.sellergoods.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.pojo.TbBrandExample.Criteria;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResult;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private TbBrandMapper brandMapper;

	@Override
	public List<TbBrand> findAll() {
		return brandMapper.selectByExample(null);
	}

	@Override
	public PageResult findByPage(int pageNum, int pageSize) {

		PageHelper.startPage(pageNum, pageSize);// 分页

		Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(null);

		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public void add(TbBrand brand) {
		brandMapper.insert(brand);
	}

	@Override
	public TbBrand findOneById(Long id) {
		return brandMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(TbBrand brand) {
		brandMapper.updateByPrimaryKey(brand);
	}

	@Override
	public void deleteByIds(Long[] ids) {
		for (Long id : ids) {
			brandMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public PageResult findByPage(TbBrand brand, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);// 分页

		TbBrandExample example = new TbBrandExample();
		Criteria criteria = example.createCriteria();
		
		if (brand!=null) {
			if (brand.getName()!=null&&brand.getName().length()>0) {
				criteria.andNameLike("%" + brand.getName() + "%");
			}
			
			if (brand.getFirstChar()!=null&&brand.getFirstChar().length()>0) {
				criteria.andFirstCharLike("%" + brand.getFirstChar() + "%");
			}
		}
		
		Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(example);

		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public List<Map> selectOptionList() {
		return brandMapper.selectOptionList();
	}

	@Override
	public int findByName(String brandName) {
		TbBrandExample example = new TbBrandExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(brandName);
		return brandMapper.countByExample(example);
	}
}

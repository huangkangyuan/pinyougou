package com.pinyougou.manager.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResult;
import entity.Result;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	private BrandService brandService;

	@RequestMapping("/findAll")
	public List<TbBrand> findAll() {
		return brandService.findAll();
	}

	@RequestMapping("/findPage")
	public PageResult findPage(int page,int rows){
		return brandService.findByPage(page, rows);
	}

	@RequestMapping("/save")
	public Result add(@RequestBody TbBrand brand){
		try {
			int brandSize = brandService.findByName(brand.getName());
			if(brandSize>0){
				return new Result(false, "品牌已存在,请重新填写");
			}
			brandService.add(brand);
			return new Result(true, "增加品牌成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加品牌失败");
		}
	}

	@RequestMapping("/findById")
	public TbBrand findById(Long id){
		return brandService.findOneById(id);
	}

	@RequestMapping("/update")
	public Result update(@RequestBody TbBrand brand){
		try {
			brandService.update(brand);
			return new Result(true, "修改品牌成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改品牌失败");
		}
	}

	@RequestMapping("/delete")
	public Result delete(Long[] ids){
		try {
			brandService.deleteByIds(ids);
			return new Result(true, "删除品牌成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除品牌失败");
		}
	}

	//PageHelper 分页BUG
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbBrand brand,@RequestParam(value = "page",defaultValue="1")Integer page,@RequestParam(value = "rows",defaultValue="10")Integer rows){
		return brandService.findByPage(brand, page, rows);
	}

	@RequestMapping("/selectOptionList")
	public List<Map> selectOptionList() {
		return brandService.selectOptionList();
	}

}

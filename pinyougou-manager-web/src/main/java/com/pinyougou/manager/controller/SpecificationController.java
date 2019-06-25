package com.pinyougou.manager.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojogroup.Specification;
import com.pinyougou.sellergoods.service.SpecificationService;

import entity.PageResult;
import entity.Result;

/**
 * controller
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/specification")
public class SpecificationController {

	@Autowired
	private SpecificationService specificationService;

	/**
	 * 返回全部列表
	 * 
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbSpecification> findAll() {
		return specificationService.findAll();
	}

	/**
	 * 返回全部列表
	 * 
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows) {
		return specificationService.findPage(page, rows);
	}

	/**
	 * 增加
	 * 
	 * @param specification
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody Specification specification) {
		
		int count = specificationService.findByName(specification.getSpecification().getSpecName());
		if (count > 0) {
			return new Result(false, "该规格已经存在,请重新填写");
		}
		
		try {
			specificationService.add(specification);
			return new Result(true, "规格增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "规格增加失败");
		}
	}

	/**
	 * 修改
	 * 
	 * @param specification
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody Specification specification) {
		try {
			specificationService.update(specification);
			return new Result(true, "规格修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "规格修改失败");
		}
	}

	/**
	 * 获取实体
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public Specification findOne(Long id) {
		return specificationService.findOne(id);
	}

	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Long[] ids) {
		try {
			specificationService.delete(ids);
			return new Result(true, "规格删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "规格删除失败");
		}
	}

	/**
	 * 查询+分页
	 * 
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbSpecification specification, int page, int rows) {
		return specificationService.findPage(specification, page, rows);
	}

	@RequestMapping("/selectOptionList")
	public List<Map> selectOptionList() {
		return specificationService.selectOptionList();
	}

}

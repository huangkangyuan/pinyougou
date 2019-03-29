package com.pinyougou.solrutil;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.pinyougou.mapper.TbItemMapper;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.pojo.TbItemExample;
import com.pinyougou.pojo.TbItemExample.Criteria;

@Component
public class SolrUtil {

	@Autowired
	private TbItemMapper itemMapper;

	@Autowired
	private SolrTemplate solrTemplate;

	public void importItemData() {

		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo("1");// 审核通过的才导入的
		List<TbItem> itemList = itemMapper.selectByExample(example);

		for (TbItem item : itemList) {
			Map specMap = JSON.parseObject(item.getSpec(), Map.class);// 从数据库中提取规格json字符串转换为map
			item.setSpecMap(specMap);
		}
		solrTemplate.saveBeans(itemList);
		solrTemplate.commit();
	}
}

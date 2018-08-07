package com.taotao.content.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.content.service.ContentService;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.pojo.TbContentExample.Criteria;

@Service
public class ContentServiceImpl implements ContentService{
@Autowired
private TbContentMapper tbContentMapper;
	
	@Override
	public List<TbContent> getContentListByCatId(Long categoryId) {
		//根据cid查询内容列表
		TbContentExample example = new TbContentExample();
		//设置查询条件
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
	    List<TbContent>	list=tbContentMapper.selectByExample(example);
		return list;
	}

}

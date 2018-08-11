package com.taotao.content.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.util.JsonUtils;
import com.taotao.content.jedis.JedisClient;
import com.taotao.content.service.ContentService;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.pojo.TbContentExample.Criteria;

@Service
public class ContentServiceImpl implements ContentService{
@Autowired
private TbContentMapper tbContentMapper;
@Autowired
private JedisClient jedisClient;

@Value("${content}")
private String CONTENTKEY;

	@Override
	public List<TbContent> getContentListByCatId(Long categoryId) {
		
		if(jedisClient.exists(CONTENTKEY)){
			System.out.println("有缓存");
			return JsonUtils.jsonToList(jedisClient.hget(CONTENTKEY, categoryId.toString()), TbContent.class);
		}
		
		//根据cid查询内容列表
		TbContentExample example = new TbContentExample();
		//设置查询条件
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
	    List<TbContent>	list=tbContentMapper.selectByExample(example);
	    
	    try {
	    	 jedisClient.hset(CONTENTKEY, categoryId.toString(),JsonUtils.objectToJson(list));
		} catch (Exception e) {
		e.printStackTrace();
		}
	    System.out.println("没缓存");
		return list;
	}

}

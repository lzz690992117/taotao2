package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
@Autowired
private TbItemMapper tbItemMapper;
	@Override
	public EasyUIDataGridResult itemList(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
	    List<TbItem>list=tbItemMapper.selectByExample(new TbItemExample());
	    PageInfo<TbItem> info=new PageInfo<TbItem>(list);
	    EasyUIDataGridResult dataGridResult=new EasyUIDataGridResult();
	    dataGridResult.setRows(list);
	    dataGridResult.setTotal((int)info.getTotal());
		return dataGridResult;
	}

}

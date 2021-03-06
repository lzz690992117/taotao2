package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.service.ItemService;

@Controller
public class ItemController {
@Autowired
private ItemService itemService;
	
@RequestMapping("/item/list")
@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page,Integer rows){
		return itemService.itemList(page, rows);
}
}

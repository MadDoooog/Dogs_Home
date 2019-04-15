package com.fc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fc.pojo.Film;
import com.fc.pojo.ResponseResult;
import com.fc.service.IndexService;

@Controller
public class IndexController {
	
	@Autowired
	private IndexService indexService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("index/movies")
	@ResponseBody
	public ResponseResult indexGetFilms() {
		ResponseResult responseResult = new ResponseResult();
		List<Film> list = indexService.indexGetFilm();
		responseResult.setList(list);
		return responseResult;
	}
}

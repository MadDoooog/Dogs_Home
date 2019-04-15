package com.fc.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fc.pojo.Film;
import com.fc.pojo.ResponseResult;
import com.fc.service.FilmService;

@Controller
//@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private FilmService filmService;
	
	@RequestMapping("/addfilm")
	@ResponseBody
	public ResponseResult addFilm(String name, String profile, Integer status) {
		ResponseResult responseResult = new ResponseResult();
		if(filmService.addFilm(name, profile, status)) {
			responseResult.setMsg("success");
		}else {
			responseResult.setMsg("failure");
		}
		return responseResult;
	}
	
	@RequestMapping("/listfilm")
	@ResponseBody
	public ResponseResult listFilm() {
		ResponseResult responseResult = new ResponseResult();
		List<Film> list = filmService.listFilm();
		if(list!=null) {
			responseResult.setMsg("success");
			responseResult.setList(list);
		}else {
			responseResult.setMsg("failure");
		}
		return responseResult;
	}
	
	@RequestMapping("/editfilm")
	@ResponseBody
	public ResponseResult edit(HttpSession session) {
		ResponseResult responseResult = new ResponseResult();
		String id = (String)session.getAttribute("film_edit");
		Film film = filmService.getFilmById(Integer.parseInt(id));
		responseResult.setObj(film);
		return responseResult;
	}
	
	@RequestMapping("/editfilmok")
	@ResponseBody
	public ResponseResult editOk(String name, String profile, Date createTime, Integer status, HttpSession session) {
		ResponseResult responseResult = new ResponseResult();
		String id = (String)session.getAttribute("film_edit");
		if(filmService.updateFilm(Integer.parseInt(id), name, profile, createTime, status)) {
			responseResult.setMsg("success");
		}else {
			responseResult.setMsg("数据插入失败！");
		}
		return responseResult;
	}

	@RequestMapping("/film_add")
	public String add() {
		return "film_add";
	}
	
	@RequestMapping("film_list")
	public String del() {
		return "film_list";
	}
	
	@RequestMapping("/film_edit_{id}")
	public String edit(@PathVariable String id, HttpSession session) {
		session.setAttribute("film_edit", id);
		return "film_edit";
	}
}

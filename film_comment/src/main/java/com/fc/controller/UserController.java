package com.fc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fc.pojo.Comment;
import com.fc.pojo.Film;
import com.fc.pojo.Labels;
import com.fc.pojo.Labs;
import com.fc.pojo.ResponseResult;
import com.fc.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("user_filmInfo_{id}")
	public String userFilmInfo(@PathVariable String id, HttpSession session) {
		session.setAttribute("user_film_id", id);
		return "user_filmInfo";
	}
	
	@RequestMapping("filmInfo")
	@ResponseBody
	public ResponseResult filmInfo(HttpSession session) {
		ResponseResult responseResult = new ResponseResult();
		
		String id = (String)session.getAttribute("user_film_id");
		
		Film film = userService.getFilmById(Integer.parseInt(id));
		responseResult.setObj(film);
		
		List<Comment> list = userService.getCommentsByFilmId(Integer.parseInt(id));
		List<Labs> list2 = userService.getLabelsByFilmId(Integer.parseInt(id));
		ArrayList<Object> arrayList = new ArrayList<>();
		arrayList.add(list2);
		arrayList.add(list);
		responseResult.setList(arrayList);
		
		return responseResult;
	}
	
	@RequestMapping("make_comments_{id}")
	public String makeComments(@PathVariable String id, HttpSession session) {
		session.setAttribute("comment_film_id", id);
		return "make_comments";
	}
	
	@RequestMapping("user_make_comments")
	@ResponseBody
	public ResponseResult userMakeComments(String content, HttpSession session) {
		Comment comment = new Comment();
		comment.setContent(content);
		comment.setFilmId(Integer.parseInt((String)session.getAttribute("comment_film_id")));
		comment.setUserId(Integer.parseInt((String)session.getAttribute("userId")));
		userService.addComments(comment);
		ResponseResult result = new ResponseResult();
		result.setMsg("success");
		return null;
	}
}

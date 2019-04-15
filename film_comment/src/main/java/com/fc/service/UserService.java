package com.fc.service;

import java.util.List;

import com.fc.pojo.Comment;
import com.fc.pojo.Film;
import com.fc.pojo.Labs;

public interface UserService {

	List<Comment> getCommentsByFilmId(Integer id);
	
	List<Labs> getLabelsByFilmId(Integer id);
	
	Film getFilmById(Integer id);
	
	void addComments(Comment comment);
	
}

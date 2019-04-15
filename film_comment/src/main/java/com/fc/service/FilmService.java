package com.fc.service;

import java.sql.Date;
import java.util.List;

import com.fc.pojo.Film;

public interface FilmService {

	boolean addFilm(String name, String profile, Integer status);
	
	boolean filmExist(Film film);
	
	List<Film> listFilm();
	
	Film getFilmById(Integer id);
	
	boolean updateFilm(Integer id, String name, String profile, Date createTime, Integer status);
}

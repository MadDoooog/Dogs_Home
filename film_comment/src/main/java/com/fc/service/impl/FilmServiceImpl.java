package com.fc.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.mapper.FilmMapper;
import com.fc.pojo.Film;
import com.fc.pojo.FilmExample;
import com.fc.pojo.FilmExample.Criteria;
import com.fc.service.FilmService;
import com.fc.util.DateUtil;
@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmMapper filmMapper;
	
	@Override
	public boolean addFilm(String name, String profile, Integer status) {
		Film film = new Film();
		film.setName(name);
		film.setProfile(profile);
		film.setStatus(status);
		if(filmExist(film)) {
			return false;
		}
		film.setCreateTime(DateUtil.longToDate(System.currentTimeMillis()));
		int i = filmMapper.insert(film);
		if(i!=0) {
			return true;			
		}
		return false;
	}

	@Override
	public boolean filmExist(Film film) {
		FilmExample example = new FilmExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(film.getName());
		List<Film> list = filmMapper.selectByExample(example);
		if(list!=null&&list.size()>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Film> listFilm() {
		FilmExample example = new FilmExample();
		Criteria criteria = example.createCriteria();
		List<Film> list = filmMapper.selectByExample(example);
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}

	@Override
	public Film getFilmById(Integer id) {
		FilmExample example = new FilmExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		List<Film> list = filmMapper.selectByExample(example);
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public boolean updateFilm(Integer id, String name, String profile, Date createTime, Integer status) {
		FilmExample example = new FilmExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		Film film = new Film();
		film.setId(id);
		film.setName(name);
		film.setProfile(profile);
		film.setCreateTime(createTime);
		film.setStatus(status);
		int i = filmMapper.updateByExample(film, example);
		if(i>0) {
			return true;
		}
		return false;
	}

}

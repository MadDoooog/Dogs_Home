package com.fc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.mapper.FilmMapper;
import com.fc.pojo.Film;
import com.fc.pojo.FilmExample;
import com.fc.pojo.FilmExample.Criteria;
import com.fc.service.IndexService;
@Service
public class IndexServiceImpl implements IndexService{

	@Autowired
	private FilmMapper filmMapper;

	@Override
	public List<Film> indexGetFilm() {
		FilmExample example = new FilmExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdGreaterThan(0);
		List<Film> list = filmMapper.selectByExample(example);
		ArrayList<Film> list2 = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			list2.add(list.get(i));
		}
		return list2;
	}
	
}

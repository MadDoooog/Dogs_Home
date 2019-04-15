package com.fc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.mapper.CommentMapper;
import com.fc.mapper.FilmMapper;
import com.fc.mapper.LabelMapper;
import com.fc.mapper.LabelsMapper;
import com.fc.pojo.Comment;
import com.fc.pojo.CommentExample;
import com.fc.pojo.CommentExample.Criteria;
import com.fc.pojo.Film;
import com.fc.pojo.FilmExample;
import com.fc.pojo.Label;
import com.fc.pojo.LabelExample;
import com.fc.pojo.Labels;
import com.fc.pojo.LabelsExample;
import com.fc.pojo.Labs;
import com.fc.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private CommentMapper commentMapper;
	
	@Autowired
	private LabelsMapper labelsMapper;
	
	@Autowired
	private FilmMapper filmMapper;
	
	@Autowired
	private LabelMapper labelMapper;
	
	@Override
	public List<Comment> getCommentsByFilmId(Integer id) {
		CommentExample example = new CommentExample();
		example.createCriteria().andFilmIdEqualTo(id);
		List<Comment> list = commentMapper.selectByExample(example);
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}

	@Override
	public List<Labs> getLabelsByFilmId(Integer id) {
		LabelsExample example = new LabelsExample();
		example.createCriteria().andFilmIdEqualTo(id);
		List<Labels> list = labelsMapper.selectByExample(example);
		
		if(list!=null&&list.size()>0) {
			List<Labs> labs = new ArrayList<>();
			for(Labels labels : list) {
				Integer labelId = labels.getLabelId();
				LabelExample example2 = new LabelExample();
				example2.createCriteria().andIdEqualTo(labelId);
				List<Label> list2 = labelMapper.selectByExample(example2);
				if(list2!=null&&list2.size()>0) {
					Label label = list2.get(0);
					Labs l = new Labs();
					l.setName(label.getName());
					l.setColor(label.getColor());
					l.setNum(labels.getNum());
					labs.add(l);
				}else {
					throw new RuntimeException("标签数据丢失！");
				}
			}
			return labs;
		}
		return null;
	}

	@Override
	public Film getFilmById(Integer id) {
		FilmExample example = new FilmExample();
		example.createCriteria().andIdEqualTo(id);
		List<Film> list = filmMapper.selectByExample(example);
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void addComments(Comment comment) {
		// TODO Auto-generated method stub
		comment.setDislikeNum(0);
		comment.setLikeNum(0);
		comment.setStatus(1);
		comment.setWarningNum(0);
		int insert = commentMapper.insert(comment);
	}

}

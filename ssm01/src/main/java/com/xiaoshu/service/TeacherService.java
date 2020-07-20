package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoshu.dao.TeacherMapper;
import com.xiaoshu.entity.Teacher;

@Service
public class TeacherService {

	@Autowired 
	private TeacherMapper teacherMapper;
	public List<Teacher> findTlist(){
		List<Teacher> list = teacherMapper.selectAll();
		return list;
		
	}
	
}

package com.xiaoshu.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoshu.dao.StudentMapper;
import com.xiaoshu.dao.TeacherMapper;
import com.xiaoshu.entity.Student;
import com.xiaoshu.entity.StudentVo;
import com.xiaoshu.entity.Teacher;

@Service
public class StudentService {

	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private TeacherMapper teacherMapper;

	public PageInfo<StudentVo> findPage(StudentVo studentVo, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<StudentVo> slist=studentMapper.findAll(studentVo);
		
		return new PageInfo<>(slist);
	}

	public void update(Student student) {
		studentMapper.updateByPrimaryKeySelective(student);
		
	}

	public void add(Student student) {
		studentMapper.insert(student);
		
	}

	public Student findByName(String sname) {
        Student student = new Student();
        student.setSname(sname);
		return studentMapper.selectOne(student);
	}

	public void delete(int parseInt) {
		studentMapper.deleteByPrimaryKey(parseInt);
		
	}

	public void importS(MultipartFile importFile) throws InvalidFormatException, IOException {
		Workbook wb = WorkbookFactory.create(importFile.getInputStream());
		Sheet sheet = wb.getSheetAt(0);
		int rowNum = sheet.getLastRowNum();
		for (int i = 0; i <rowNum; i++) {
			Row row = sheet.getRow(i+1);
			String name = row.getCell(0).toString();
			String gender = row.getCell(1).toString();
			int age = (int) row.getCell(2).getNumericCellValue();
			Date birthday = row.getCell(3).getDateCellValue();
			String img = row.getCell(4).toString();
			String sname = row.getCell(5).toString();
			
			Student student = new Student();
			student.setSname(name);
			student.setGender(gender.equals("男")?"1":"0");
			student.setAge(age);
			student.setBirthday(birthday);
			student.setImg(img);
			Teacher teacher = findByTname(sname);
			student.setTid(teacher.getTid());
			add(student);
			
		}
		
	}
	public Teacher findByTname(String name){
		Teacher teacher = new Teacher();
		teacher.setTname(name);
		Teacher teacher2 = teacherMapper.selectOne(teacher);
		return teacher2;
	}

	public List<StudentVo> findS(StudentVo studentVo) {
		List<StudentVo> slist=studentMapper.findAll(studentVo);
		return slist;
	}
	
	
}

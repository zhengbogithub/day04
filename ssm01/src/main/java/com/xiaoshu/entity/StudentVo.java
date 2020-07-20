package com.xiaoshu.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class StudentVo extends Student{
   
	private String tname;
	private Integer age1;
	private Integer age2;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday1;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday2;
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Integer getAge1() {
		return age1;
	}
	public void setAge1(Integer age1) {
		this.age1 = age1;
	}
	public Integer getAge2() {
		return age2;
	}
	public void setAge2(Integer age2) {
		this.age2 = age2;
	}
	public Date getBirthday1() {
		return birthday1;
	}
	public void setBirthday1(Date birthday1) {
		this.birthday1 = birthday1;
	}
	public Date getBirthday2() {
		return birthday2;
	}
	public void setBirthday2(Date birthday2) {
		this.birthday2 = birthday2;
	}
	
	
}

package com.kyk.jspServlet16;

//bean클래스로 멤버변수에 대한 getter, setter메서드를 가진 클래스
//DTO클래스 또는 VO(ValueObject)라고도 함
public class Student {
	//멤버변수(속성)
	private String name;
	private int age;
	private int grade;
	private int studentNum;
	
	public Student() {
		super();
	}

	public Student(String name, int age, int grade, int studentNum) {
		super();
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.studentNum = studentNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}
}

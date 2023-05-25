package com.cdac.MyJdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cdac.MyJdbc.model.Student;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student=new Student(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getString(4));
		return student;
	}

}

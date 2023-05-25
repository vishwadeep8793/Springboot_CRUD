package com.cdac.MyJdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cdac.MyJdbc.model.Student;

@Repository
public class StudentDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	private static final String INSERT_STUDENT = "insert into students (name,email,city) values (?,?,?,?)";
	private static final String SELECT_STUDENT_BY_ID = "select * from students where ID=?";
	private static final String SELECT_ALL_STUDENTS = "select * from students";
	private static final String DELETE_STUDENT = "delete from students where ID=?";
	private static final String UPDATE_STUDENT = "update students set name=?, email=?, city=? where id=?";

	public StudentDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int createTable() {
		String query = "CREATE TABLE IF NOT EXISTS students(id int primary key auto_increment, name varchar(50),email varchar(50),city varchar(50))";
		int update = jdbcTemplate.update(query);
		return update;
	}

	public Object getStudent(int id) {
		RowMapper<Student> rowMap = new StudentRowMapper();
		Student student = this.jdbcTemplate.queryForObject(SELECT_STUDENT_BY_ID, rowMap, id);
		return student;
	}

	public void update(Student student, int id) {
		int affectedRows = this.jdbcTemplate.update(UPDATE_STUDENT, student.getName(), student.getEmail(),
				student.getCity(), student.getId());
		if (affectedRows > 0) {
			System.out.println("Record Updated Successfully");
		}

	}

	public void delete(int sId) {
		int affectedRows = this.jdbcTemplate.update(DELETE_STUDENT, sId);
		if (affectedRows > 0) {
			System.out.println("Record Deleted Successfully");
		}

	}

	public void insertStudent(Student student) {
		int affectedRows = this.jdbcTemplate.update(INSERT_STUDENT, student.getEmail(), student.getName(),
				student.getCity());
		if (affectedRows > 0) {
			System.out.println("Record Inserted");
		}
	}

	public List<Student> showStudents() {
		List<Student> students = this.jdbcTemplate.query(SELECT_ALL_STUDENTS, new StudentRowMapper());
		return students;
	}

}

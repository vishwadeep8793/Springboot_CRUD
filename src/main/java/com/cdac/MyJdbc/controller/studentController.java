package com.cdac.MyJdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdac.MyJdbc.dao.StudentDao;
import com.cdac.MyJdbc.model.Student;
@Controller
public class studentController {
	@Autowired
	StudentDao studentDao;
	
	@RequestMapping("/")
	public String getAllStudents(Model model) {
		List<Student> students=studentDao.showStudents();
		model.addAttribute("listStudent", students);
		return "showStudent";
	}
	
	@GetMapping("/edit/{id}")
	public String editStudent(@PathVariable int id,Model model) {
//		Student student=ss.getStudent(sId);
		model.addAttribute("student", studentDao.getStudent(id));
		return "newStudent";
	}
	
	@PostMapping("/update")
	public String updateStudent(@ModelAttribute Student student) {
		studentDao.update(student, student.id);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") int sId)
	{
		studentDao.delete(sId);
		return "redirect:/ ";
	}
	
	@GetMapping("/new")
	public String addStudent(Model model)
	{
		model.addAttribute("student",new Student());
		return "newStudent";
	}
	
	@PostMapping("/insert")
	public void insertStudent(@ModelAttribute Student student)
	{
		studentDao.insertStudent(student);
	
	}

}

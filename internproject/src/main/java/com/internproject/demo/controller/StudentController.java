package com.internproject.demo.controller;

import java.util.List;   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.internproject.demo.Service.StudentService;
import com.internproject.demo.constant.GlobalConstant;
import com.internproject.demo.entity.Student;
import com.internproject.demo.pojo.StudentPojo;
import com.internproject.demo.response.BaseResponse;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@GetMapping (value = "/internship")
	public BaseResponse getStudent() {
		List<Student> students= studentService.getStudent();
		return new BaseResponse(GlobalConstant.SUCCESS, students,GlobalConstant.Message.SUCCESS_MESSAGE);
	}
	
//	@GetMapping (value = "/internship")
//	public List<Student> getStudent() {
//		return studentService.getStudent();
//	}
//	
	
	@PostMapping (value = "/internship")
	public BaseResponse addStudent(@RequestBody Student student)
	{
	
		try {
       student = studentService.save(student);
		}catch (Exception e) {
			System.out.println("Error occur "+e.getMessage());
			return new BaseResponse(GlobalConstant.FAIL, null,GlobalConstant.Message.FAIL_MESSAGE);
		}
		return new BaseResponse(GlobalConstant.SUCCESS, student,GlobalConstant.Message.SUCCESS_MESSAGE);
	}
	

//	@PostMapping (value = "/internship")
//	public Student addstudent(@RequestBody Student student) {
//		return studentService.addStudent(student);
//	}
	@GetMapping (value = "/internship/{id}")
	public BaseResponse getById(@PathVariable Long id) {
		Student student = studentService.findById(id);
		return new BaseResponse(GlobalConstant.SUCCESS, student,GlobalConstant.Message.SUCCESS_MESSAGE);
	}
	@DeleteMapping (value = "/internship/{id}")
	public void deleteById(@PathVariable long id) {
		studentService.deleteStudent(id);
	}
	@PutMapping (value = "/student")
	public BaseResponse updateStudent(@RequestBody StudentPojo studentPojo) {
		
		Student student = studentService.findById(studentPojo.getId());
		if(student==null) {
			return null;
		}
		student.setPhone(studentPojo.getPhone());
		student.setRollNo(studentPojo.getRollNo());
		Student students = studentService.save(student);
		return new BaseResponse(GlobalConstant.SUCCESS, students,GlobalConstant.Message.SUCCESS_MESSAGE);

		
	}
}

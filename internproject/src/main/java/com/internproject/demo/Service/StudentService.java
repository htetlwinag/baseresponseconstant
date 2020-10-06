package com.internproject.demo.Service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internproject.demo.entity.Student;
import com.internproject.demo.repository.StudentRepository;


@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> getStudent() {
		return studentRepository.findAll();
	}
	
	public Student addStudent (Student student) {
		return studentRepository.save(student);
	}
	
	public Student findById(Long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).orElse(null);
	}
	public void deleteStudent(long id) {
		studentRepository.deleteById(id);
	}

	public Student save(Student student) {
		return studentRepository.save(student);
	}
	
}

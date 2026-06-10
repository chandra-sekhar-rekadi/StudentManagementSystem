package com.students.management.system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.students.management.system.entity.StudentEntity;
import com.students.management.system.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentEntity saveStudent(@RequestBody StudentEntity studentEntity) {

        return studentService.saveStudentDetails(studentEntity);
    }

    @GetMapping
    public List<StudentEntity> getStudents() {

        return studentService.getStudentDetails();
    }

    @GetMapping("/{id}")
    public StudentEntity getStudentById(@PathVariable Long id) {

        return studentService.getStudentDetailsById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {

        studentService.deteleStudentDetailsById(id);

        return "Student Deleted Successfully";
    }
    
    @PatchMapping("/{id}")
    public void updatedById(@RequestBody StudentEntity stdDo, @PathVariable("id") Long studentId) {

        studentService.updateById(stdDo, studentId);
    }
}
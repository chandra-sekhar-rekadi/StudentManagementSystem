package com.students.management.system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.students.management.system.entity.StudentEntity;
import com.students.management.system.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService stuService) {
        this.studentService = stuService;
    }

    @PostMapping
    public StudentEntity saveStudent(@RequestBody StudentEntity stdEntDO) {

        return studentService.saveStudentDetails(stdEntDO);
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
    public void updatedById(@RequestBody StudentEntity strEntDO, @PathVariable("id") Long studentId) {

        studentService.updateById(strEntDO, studentId);
    }
}
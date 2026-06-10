package com.students.management.system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.students.management.system.entity.StudentEntity;
import com.students.management.system.globalException.StudentNotFound;
import com.students.management.system.repo.StudentRepo;
import com.students.management.system.service.impl.StudentImpl;

@Service
public class StudentService implements StudentImpl {

    private StudentRepo studentRep;

    public StudentService(StudentRepo studentRep) {
        this.studentRep = studentRep;
    }

    @Override
    public StudentEntity saveStudentDetails(StudentEntity struEntity) {

        return studentRep.save(struEntity);
    }

    @Override
    public StudentEntity getStudentDetailsById(Long studentId) {

        return studentRep.findById(studentId).orElseThrow(()->new  StudentNotFound("Student Not Found :"+studentId));
    }

    @Override
    public List<StudentEntity> getStudentDetails() {

        return studentRep.findAll();
    }

    @Override
    public void deteleStudentDetailsById(Long studentId) {

        studentRep.deleteById(studentId);
    }

	@Override
	public void updateById(StudentEntity stdEnt , Long studentId) {
		StudentEntity getStu = studentRep.findById(studentId).get();
		getStu.setStudentName(stdEnt.getStudentName());
		getStu.setStudentAddress(stdEnt.getStudentAddress());
		getStu.setStudentSection(stdEnt.getStudentSection());
		
	 studentRep.save(getStu);
	}
}
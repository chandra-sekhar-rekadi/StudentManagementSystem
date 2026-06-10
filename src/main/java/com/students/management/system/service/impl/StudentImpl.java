package com.students.management.system.service.impl;

import java.util.List;

import com.students.management.system.entity.StudentEntity;

public interface StudentImpl {
  
	StudentEntity saveStudentDetails(StudentEntity studentDO);
	StudentEntity getStudentDetailsById(Long studentId);
	List<StudentEntity> getStudentDetails();
	void deteleStudentDetailsById(Long studentId);
    void updateById(StudentEntity stdEnt, Long studentId);
}

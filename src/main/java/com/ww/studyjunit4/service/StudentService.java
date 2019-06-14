package com.ww.studyjunit4.service;

import com.ww.studyjunit4.entity.Student;

import java.util.List;

/**
 * @author: Sun
 * @create: 2019-06-13 16:31
 * @version: v1.0
 */
public interface StudentService {

    Student saveStudent(Student student);

    Student findByStudentIdReturnEntity( Student student);

    Student findAllByStudentIdReturnEntity(Student student);

    List<Student> findByStudentIdReturnList(Student student);

    List<Student> findAllByStudentIdReturnList(Student student);

    void deleteStudent(Student student);
}

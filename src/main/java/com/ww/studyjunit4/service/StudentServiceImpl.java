package com.ww.studyjunit4.service;

import com.ww.studyjunit4.constant.DeleteState;
import com.ww.studyjunit4.entity.Student;
import com.ww.studyjunit4.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author: Sun
 * @create: 2019-06-13 16:31
 * @version: v1.0
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.saveAndFlush(student);
    }

    @Override
    public Student findByStudentIdReturnEntity(Student student) {
        // return studentRepository.findByStudentId(student.getStudentId());
        return null;
    }

    @Override
    public Student findAllByStudentIdReturnEntity(Student student) {
        // return studentRepository.findByStudentId(student.getStudentId());
        return null;
    }

    @Override
    public List<Student> findByStudentIdReturnList(Student student) {
        return studentRepository.findByStudentId(student.getStudentId());
    }

    @Override
    public List<Student> findAllByStudentIdReturnList(Student student) {
        // return studentRepository.findAllByStudentId(student.getStudentId());
        return null;
    }

    @Override
    public void deleteStudent(Student student) {
        Optional<Student> byId = studentRepository.findById(student.getId());
        if (byId.isPresent()) {
            byId.get().setDeleteState(DeleteState.DELETED);
            studentRepository.saveAndFlush(byId.get());
        }
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Student student) {
        Optional<Student> byId = studentRepository.findById(student.getId());
        return byId.orElse(null);
    }
}

package com.ww.studyjunit4.controller;

import com.ww.studyjunit4.entity.Student;
import com.ww.studyjunit4.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * I have a problem when using JPA：
 *
 * I am using a method name to create a query.
 * In the process of writing code, I found two such syntaxes, <p>findByStudentId<p/> & <p>findAllByStudentId</p>,
 * and I want to know the difference between the two methods. So come and test.
 *
 * Test the difference between findBy and findAll in JPA.
 * @author: Sun
 * @create: 2019-06-13 11:34
 * @version: v1.0
 */
@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * Find Student Entity By Student Id.  (By: JPA findBy)
     * @param: student
     * @throws:
     * @return: void
     * @author: Sun
     * @date: 2019-06-14 10:46
     */
    @RequestMapping(value = "/findByStudentIdReturnEntity")
    public Student findByStudentIdReturnEntity(@RequestBody Student student) {
        // return studentService.findByStudentIdReturnEntity(student);
        return null;
    }

    /**
     * Find Student Entity By Student Id.  (By: JPA findAllBy)
     * @param: student
     * @throws:
     * @return: void
     * @author: Sun
     * @date: 2019-06-14 10:46
     */
    @RequestMapping(value = "/findAllByStudentIdReturnEntity")
    public Student findAllByStudentIdReturnEntity(@RequestBody Student student) {
       // studentService.findAllByStudentIdReturnEntity(student);
        return null;
    }

    /**
     * Find List<Student> By Student Id.  (By: JPA findBy)
     * @param: student
     * @throws:
     * @return: void
     * @author: Sun
     * @date: 2019-06-14 10:48
     */
    @RequestMapping(value = "/findByStudentIdReturnList")
    public List<Student> findByStudentIdReturnList(@RequestBody Student student) {
       return studentService.findByStudentIdReturnList(student);
    }

    /**
     * Find List<Student> By Student Id.  (By: JPA findAllBy)
     * @param: student
     * @throws:
     * @return: void
     * @author: Sun
     * @date: 2019-06-14 10:48
     */
    @RequestMapping(value = "/findAllByStudentIdReturnList")
    public List<Student> findAllByStudentIdReturnList(@RequestBody Student student) {
       // return studentService.findAllByStudentIdReturnList(student);
        return null;
    }

    /**
     * Save student.
     * @param: student
     * @throws:
     * @return: Student
     * @author: Sun
     * @date: 2019-06-14 10:23
     */
    @RequestMapping(value = "/saveStudent")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    /**
     * Update student.
     * @param: student
     * @throws:
     * @return: com.ww.studyjunit4.entity.Student
     * @author: Sun
     * @date: 2019-06-14 11:24
     */
    @RequestMapping(value = "/updateStudent")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    /**
     * Delete Student.
     * @param: student
     * @throws:
     * @return: void
     * @author: Sun
     * @date: 2019-06-14 11:26
     */
    @RequestMapping(value = "/deleteStudent")
    public void deleteStudent(@RequestBody Student student) {
        studentService.deleteStudent(student);
    }

}

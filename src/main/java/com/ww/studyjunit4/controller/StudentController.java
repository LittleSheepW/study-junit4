package com.ww.studyjunit4.controller;

import com.ww.studyjunit4.api.ApiResult;
import com.ww.studyjunit4.entity.Student;
import com.ww.studyjunit4.service.StudentService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
        log.info("[findByStudentIdReturnEntity] [入参] [student:{}]", student);
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
        log.info("[findAllByStudentIdReturnEntity] [入参] [student:{}]", student);
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
    public ApiResult findByStudentIdReturnList(@RequestBody Student student) {
        log.info("[findByStudentIdReturnList] [入参] [student:{}]", student);
        return ApiResult.success(studentService.findByStudentIdReturnList(student));
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
        log.info("[findAllByStudentIdReturnList] [入参] [student:{}]", student);
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
    public ApiResult saveStudent(@RequestBody Student student) {
        log.info("[saveStudent] [入参] [student:{}]", student);
        return ApiResult.success(studentService.saveStudent(student).getId());
    }

    /**
     * Find all student.
     * @param:
     * @throws:
     * @return: com.ww.studyjunit4.api.ApiResult
     * @author: Sun
     * @date: 2019-06-14 12:23
     */
    @RequestMapping(value = "/findAll")
    public ApiResult findAll() {
        log.info("[findAll] [无入参]");
        return ApiResult.success(studentService.findAll());
    }

    /**
     * Find student by Id.
     * @param: student
     * @throws:
     * @return: com.ww.studyjunit4.api.ApiResult
     * @author: Sun
     * @date: 2019-06-14 14:10
     */
    @RequestMapping(value = "/findById")
    public ApiResult findById(@RequestBody Student student) {
        log.info("[findById] [入参] [student:{}]", student);
        return ApiResult.success(studentService.findById(student));
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
    public ApiResult updateStudent(@RequestBody Student student) {
        log.info("[updateStudent] [入参] [student:{}]", student);
        return ApiResult.success(studentService.saveStudent(student).getId());
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
    public ApiResult deleteStudent(@RequestBody Student student) {
        log.info("[deleteStudent] [入参] [student:{}]", student);
        studentService.deleteStudent(student);
        return ApiResult.success();
    }

}

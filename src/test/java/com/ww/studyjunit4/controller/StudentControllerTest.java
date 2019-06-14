package com.ww.studyjunit4.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ww.studyjunit4.api.ApiResult;
import com.ww.studyjunit4.constant.DeleteState;
import com.ww.studyjunit4.entity.Student;
import com.ww.studyjunit4.repository.StudentRepository;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * StudentController test class.
 *
 * @author: Sun
 * @create: 2019-06-13 11:34
 * @version: v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class StudentControllerTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TestRestTemplate testRestTemplate;

    /**
     * The following two fields are set to static. If not set to static, the following will occur.
     *
     * eg: The stuUp() method is called in the a_testSaveStudent() method to initialize the Student student,
     * but when the JUnit executes the b_testFindAll() method, it is empty if the student object is used.
     */
    private static Student student;
    private static Integer id;

    private ObjectMapper objectMapper = new ObjectMapper();


    public void setUp() {
        student = new Student();
        student.setName("sun");
        student.setStudentId(6);
        student.setCreateTime(12345678L);
        student.setDeleteState(DeleteState.NORMAL);
    }

    public void tearDown() {
        System.out.println("Test method end");
    }

    @Test
    public void a_testSaveStudent() throws IOException, JSONException {
        setUp();
        // print request param
        System.out.println("request param:" + objectMapper.writeValueAsString(student));
        String result = testRestTemplate.postForObject("/student/saveStudent", student, String.class);
        // print response result
        System.out.println("result:" + result);
        JsonNode jsonNode = objectMapper.readTree(result);
        id = jsonNode.path("data").asInt();
        String expected = objectMapper.writeValueAsString(ApiResult.success(id));

        student.setId(id);

        JSONAssert.assertEquals(expected, result, false);
    }

    @Test
    public void b_testFindAll() throws IOException, JSONException {
        // mock return data
        List<Student> studentList = new ArrayList<>();
        Student mockStudent = new Student();
        mockStudent.setId(1);
        mockStudent.setName("sun");
        mockStudent.setStudentId(6);
        mockStudent.setCreateTime(12345678L);
        mockStudent.setDeleteState(DeleteState.NORMAL);
        studentList.add(mockStudent);
        String expected = objectMapper.writeValueAsString(ApiResult.success(studentList));

        String result = testRestTemplate.getForObject("/student/findAll", String.class);
        // print response result
        System.out.println("result:" + result);

        JSONAssert.assertEquals(expected, result, false);
    }

    @Test
    public void c_testFindById() throws IOException, JSONException {
        // mock return data
        Student mockStudent = new Student();
        mockStudent.setId(id);
        mockStudent.setName("sun");
        mockStudent.setStudentId(6);
        mockStudent.setCreateTime(12345678L);
        mockStudent.setDeleteState(DeleteState.NORMAL);
        String expected = objectMapper.writeValueAsString(ApiResult.success(mockStudent));

        String result = testRestTemplate.postForObject("/student/findById", student, String.class);
        // print response result
        System.out.println("result:" + result);

        JSONAssert.assertEquals(expected, result, false);
    }

    @Test
    public void d_testUpdateStudent() throws IOException, JSONException {
        Student updateStudent = new Student();
        updateStudent.setId(id);
        updateStudent.setName("ran");
        updateStudent.setStudentId(6);
        updateStudent.setCreateTime(87654321L);

        String result = testRestTemplate.postForObject("/student/updateStudent", updateStudent, String.class);
        // print response result
        System.out.println("result:" + result);

        JsonNode jsonNode = objectMapper.readTree(result);
        id = jsonNode.path("data").asInt();
        String expected = objectMapper.writeValueAsString(ApiResult.success(id));

        JSONAssert.assertEquals(expected, result, false);
    }

    @Test
    public void e_testDeleteStudent() {
        student.setId(id);
        String result = testRestTemplate.postForObject("/student/deleteStudent", student, String.class);
        // print response result
        System.out.println("result:" + result);

        Student studentById = studentRepository.findById(id).get();
        Assertions.assertThat(studentById.getDeleteState()).isEqualTo(DeleteState.DELETED);
    }
}
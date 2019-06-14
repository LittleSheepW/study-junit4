package com.ww.studyjunit4.repository;

import com.ww.studyjunit4.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Final conclusion:
 * The sql statements parsed by findBy and findAllBy are the same, just the syntax is different.
 *
 * If you are not sure that there is only one data returned, use List<T> to receive it, to prevent it from appearing:
 * <p>NonUniqueResultException</p>：query did not return a unique result: 2
 *
 * @author: Sun
 * @create: 2019-06-13 11:29
 * @version: v1.0
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    /**
     * 报错，SQL语句查询时就查出来了所有匹配的数据(多条数据)，但是返回的却只是一个Entity
     * select student0_.id as id1_0_, student0_.create_time as create_t2_0_,
     * student0_.name as name3_0_, student0_.student_id as student_4_0_
     * from student student0_ where student0_.student_id=1
     */
    // Student findByStudentId(@Param("studentId") Integer studentId);

    /**
     * 无报错，正常返回
     * select student0_.id as id1_0_, student0_.create_time as create_t2_0_,
     * student0_.name as name3_0_, student0_.student_id as student_4_0_
     * from student student0_ where student0_.student_id=?
     */
    List<Student> findByStudentId(Integer studentId);

    /**
     * 报错，SQL语句查询时就查出来了所有匹配的数据(多条数据)，但是返回的却只是一个Entity
     * select student0_.id as id1_0_, student0_.create_time as create_t2_0_,
     * student0_.name as name3_0_, student0_.student_id as student_4_0_
     * from student student0_ where student0_.student_id=?
     */
    // Student findAllByStudentId(Integer studentId);

    /**
     * 无报错，正常返回
     * select student0_.id as id1_0_, student0_.create_time as create_t2_0_,
     * student0_.name as name3_0_, student0_.student_id as student_4_0_
     * from student student0_ where student0_.student_id=?
     */
    // List<Student> findAllByStudentId(Integer studentId);




}

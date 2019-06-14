package com.ww.studyjunit4.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * The Student entity.
 * @author: Sun
 * @create: 2019-06-13 11:28
 * @version: v1.0
 */
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer studentId;

    private String name;

    private Long createTime;

    private Integer deleteState;

}

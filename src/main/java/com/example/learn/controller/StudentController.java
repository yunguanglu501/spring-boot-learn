package com.example.learn.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.learn.entity.EduStudent;
import com.example.learn.entity.Student;
import com.example.learn.mapper.EduStudentMapper;
import com.example.learn.mapper.StudentMapper;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/8 17:17
 */
@RestController
public class StudentController  {

//    @Autowired
//    EduStudentMapper eduStudentMapper;
//
//    @RequestMapping("getOne")
//    public EduStudent getOne() {
//        LambdaQueryWrapper<EduStudent> lambdaQueryWrapper = Wrappers.lambdaQuery();
//        LambdaQueryWrapper<EduStudent> eq = lambdaQueryWrapper.eq(EduStudent::getStuId, "1001");
//        EduStudent entity = eq.getEntity();
//        System.out.println("entity = " + entity);
//
//        EduStudent eduStudent = eduStudentMapper.selectOne(eq);
//        System.out.println("eduStudent = " + eduStudent);
//        return eduStudent;
//
//    }

    @Autowired
    StudentMapper studentMapper;

    @RequestMapping("save")
    public Student save() {
        Student student = new Student();
        student.setStuId("222");
        student.setStuName("张三22");
        studentMapper.insert(student);
        return student;
    }


    @RequestMapping("updateById")
    public Student updateById() {
        Student student = new Student();
        student.setStuId("222");
        student.setStuName("李师师5");
        student.setStuAge(null);
        studentMapper.updateById(student);
        return student;
    }

    @RequestMapping("update")
    public Student update() {
        Student student = new Student();
        student.setStuName("李师师5");
        student.setStuAge(null);
        studentMapper.update(student,Wrappers.<Student>lambdaUpdate().eq(Student::getStuId,222));
        return student;

    }

    @RequestMapping("selectBatch")
    public List<Student> selectBatch() {

        List<Student> students = studentMapper.selectBatchIds(Lists.newArrayList("1001", "1006", "222"));
        return students;

    }

    @RequestMapping("selectOne")
    public Student selectOne() {

        Student student = studentMapper.selectOne(Wrappers.<Student>lambdaQuery().select(Student::getStuName,Student::getStuId).eq(Student::getStuName, "李师师5"));
        return student;

    }

    @RequestMapping("selectPage")
    public List<Student> selectPage() {

//        IPage<Student> page = new Page<Student>(1, 2);
//        IPage<Student> studentPage = studentMapper.selectPage(page, Wrappers.<Student>lambdaQuery().eq(Student::getIsDel, 0));
//        System.out.println("studentPage2 = " + JSON.toJSONString(studentPage));
//
//        long pages = studentPage.getPages();
//        System.out.println("pages = " + pages);
//        long total = studentPage.getTotal();
//        System.out.println("total = " + total);
//        long current = studentPage.getCurrent();
//        System.out.println("current = " + current);
//        long size = studentPage.getSize();
//        System.out.println("size = " + size);
//        return studentPage.getRecords();
        PageHelper.startPage(1,2);
        List<Student> students = studentMapper.listStudents();
        System.out.println("students = " + JSON.toJSONString(students));
        return students;

    }





}

package com.tuwaiq.week8_day4_schoolmanagement.Service;

import com.tuwaiq.week8_day4_schoolmanagement.Api.ApiException;
import com.tuwaiq.week8_day4_schoolmanagement.DTOOUT.TeacherDTOOut;
import com.tuwaiq.week8_day4_schoolmanagement.Model.Address;
import com.tuwaiq.week8_day4_schoolmanagement.Model.Course;
import com.tuwaiq.week8_day4_schoolmanagement.Model.Teacher;
import com.tuwaiq.week8_day4_schoolmanagement.Repository.AddressRepository;
import com.tuwaiq.week8_day4_schoolmanagement.Repository.CourseRepository;
import com.tuwaiq.week8_day4_schoolmanagement.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;
    private final CourseRepository courseRepository;

    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }

    public void updateTeacher(Integer id, Teacher teacher){
        Teacher oldTeacher=teacherRepository.findTeacherById(id);
        if (oldTeacher==null){
            throw new ApiException("No teacher found");
        }
        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setEmail(teacher.getEmail());
        oldTeacher.setSalary(teacher.getSalary());
        teacherRepository.save(oldTeacher);
    }

    public void deleteTeacher(Integer id){
        Teacher teacher=teacherRepository.findTeacherById(id);
        if (teacher==null){
            throw new ApiException("Teacher not found");
        }
        teacherRepository.delete(teacher);
    }

    public TeacherDTOOut getTeacherInfoById(Integer id){
        Teacher teacher=teacherRepository.findTeacherById(id);
        Address address=addressRepository.findAddressById(teacher.getAddress().getId());
        List<Course> courses=courseRepository.findCoursesByTeacher_Id(teacher.getId());
        return new TeacherDTOOut(teacher.getId(), teacher.getName(), teacher.getAge(), teacher.getEmail(), teacher.getSalary(), address.getArea(), address.getStreet(), address.getBuildingNumber(), courses);
    }
}

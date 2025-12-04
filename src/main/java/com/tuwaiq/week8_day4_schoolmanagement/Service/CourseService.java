package com.tuwaiq.week8_day4_schoolmanagement.Service;

import com.tuwaiq.week8_day4_schoolmanagement.Api.ApiException;
import com.tuwaiq.week8_day4_schoolmanagement.DTOOUT.CourseDTO;
import com.tuwaiq.week8_day4_schoolmanagement.Model.Course;
import com.tuwaiq.week8_day4_schoolmanagement.Model.Teacher;
import com.tuwaiq.week8_day4_schoolmanagement.Repository.CourseRepository;
import com.tuwaiq.week8_day4_schoolmanagement.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    public void updateCourse(Integer id, Course course){
        Course oldCourse=courseRepository.findCoursesById(id);
        if (oldCourse==null){
            throw new ApiException("Course not found");
        }
        oldCourse.setName(course.getName());
        courseRepository.save(oldCourse);
    }

    public void deleteCourse(Integer id){
        Course course=courseRepository.findCoursesById(id);
        if (course==null){
            throw new ApiException("Course not found");
        }
        courseRepository.delete(course);
    }

    public void assignTeacherToCourse(Integer teacherId,Integer courseId){
        Teacher teacher=teacherRepository.findTeacherById(teacherId);
        Course course=courseRepository.findCoursesById(courseId);
        if (course==null || teacher==null){
            throw new ApiException("Can't assign teacher to course");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    public void unAssignCourse(Integer courseId){
        Course course=courseRepository.findCoursesById(courseId);
        course.setTeacher(null);
        courseRepository.save(course);
    }

    public CourseDTO getCourseInfo(Integer courseId){
        Course course=courseRepository.findCoursesById(courseId);
        if (course==null){
            throw new ApiException("Course not found");
        }
        Teacher teacher=teacherRepository.findTeacherById(course.getTeacher().getId());
        if (teacher==null){
            return new CourseDTO(course.getId(), course.getName(), null);
        }
        return new CourseDTO(course.getId(), course.getName(), course.getTeacher().getName());
    }
}

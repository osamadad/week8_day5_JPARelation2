package com.tuwaiq.week8_day4_schoolmanagement.Repository;

import com.tuwaiq.week8_day4_schoolmanagement.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

    Course findCoursesById(Integer id);

    List<Course> findCoursesByTeacher_Id(Integer teacherId);
}

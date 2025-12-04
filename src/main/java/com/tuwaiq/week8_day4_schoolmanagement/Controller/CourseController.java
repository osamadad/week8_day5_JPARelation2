package com.tuwaiq.week8_day4_schoolmanagement.Controller;

import com.tuwaiq.week8_day4_schoolmanagement.Api.ApiResponse;
import com.tuwaiq.week8_day4_schoolmanagement.Model.Course;
import com.tuwaiq.week8_day4_schoolmanagement.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@RequestBody @Valid Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("Course added successfully"));
    }

    @GetMapping("/get")
    public ResponseEntity<?> getCourses(){
        return ResponseEntity.status(200).body(courseService.getCourses());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer id, @RequestBody @Valid Course course){
        courseService.updateCourse(id,course);
        return ResponseEntity.status(200).body(new ApiResponse("Course updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("Course delete successfully"));
    }

    @PutMapping("/assign-teacher-course/{teacherId}/{courseId}")
    public ResponseEntity<?> assignTeacherToCourse(@PathVariable Integer teacherId, @PathVariable Integer courseId){
        courseService.assignTeacherToCourse(teacherId,courseId);
        return ResponseEntity.status(200).body(new ApiResponse("The teacher have been assign to the course successfully"));
    }

    @PutMapping("/unassign-course/{courseId}")
    public ResponseEntity<?> unAssignCourse(@PathVariable Integer courseId){
        courseService.unAssignCourse(courseId);
        return ResponseEntity.status(200).body(new ApiResponse("The course have been unassigned successfully"));
    }

    @GetMapping("/get-course-info/{courseId}")
    public ResponseEntity<?> getCourseInfo(@PathVariable Integer courseId){
        return ResponseEntity.status(200).body(courseService.getCourseInfo(courseId));
    }
}

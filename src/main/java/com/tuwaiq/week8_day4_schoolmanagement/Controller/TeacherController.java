package com.tuwaiq.week8_day4_schoolmanagement.Controller;

import com.tuwaiq.week8_day4_schoolmanagement.Api.ApiResponse;
import com.tuwaiq.week8_day4_schoolmanagement.Model.Teacher;
import com.tuwaiq.week8_day4_schoolmanagement.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping("/add")
    public ResponseEntity<?> addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("The teacher have been added successfully"));
    }

    @GetMapping("/get")
    public ResponseEntity<?> getTeachers(){
        return ResponseEntity.status(200).body(teacherService.getTeachers());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable Integer id, @RequestBody @Valid Teacher teacher){
        teacherService.updateTeacher(id,teacher);
        return ResponseEntity.status(200).body(new ApiResponse("The teacher have been updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("The teacher have been deleted successfully"));
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<?> getTeacherById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(teacherService.getTeacherById(id));
    }
}

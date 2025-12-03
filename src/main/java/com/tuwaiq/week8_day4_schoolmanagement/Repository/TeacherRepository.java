package com.tuwaiq.week8_day4_schoolmanagement.Repository;

import com.tuwaiq.week8_day4_schoolmanagement.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

    Teacher findTeacherById(Integer id);
}

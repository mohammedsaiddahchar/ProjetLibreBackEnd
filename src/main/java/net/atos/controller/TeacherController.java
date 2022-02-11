package net.atos.controller;

import net.atos.model.FullTimeTeacher;
import net.atos.model.PartTimeTeacher;
import net.atos.model.Teacher;
import net.atos.service.PartTimeTeacherService;
import net.atos.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @RequestMapping("")
    public String index() {
        return "hoho";
    }

    @PostMapping("/add")
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
        Teacher newTeacher = teacherService.addTeacher(teacher);
        return new ResponseEntity<>(newTeacher, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher) {
        Teacher updatedTeacher = teacherService.updateTeacher(teacher);
        return new ResponseEntity<>(updatedTeacher, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeacherById(@PathVariable Long id) {
        teacherService.deleteTeacherById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Teacher> findTeacherById(@PathVariable Long id) {
        Teacher foundTeacher = teacherService.findTeacherById(id);
        return new ResponseEntity<>(foundTeacher, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Teacher>> findAllTeachers() {
        List<Teacher> listTeacher = teacherService.findAllTeachers();
        return new ResponseEntity<>(listTeacher, HttpStatus.OK);
    }
}

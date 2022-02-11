package net.atos.controller;

import net.atos.model.FullTimeTeacher;
import net.atos.service.FullTimeTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/fulltimeteacher")
public class FullTimeTeacherController {
    @Autowired
    FullTimeTeacherService fullTimeTeacherService;

    @RequestMapping("")
    public String index() {
        return "hoho";
    }

    @PostMapping("/add")
    public ResponseEntity<FullTimeTeacher> addFullTimeTeacher(@RequestBody FullTimeTeacher fullTimeTeacher) {
        FullTimeTeacher newFullTimeTeacher = fullTimeTeacherService.addFullTimeTeacher(fullTimeTeacher);
        return new ResponseEntity<>(newFullTimeTeacher, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<FullTimeTeacher> updateFullTimeTeacher(@RequestBody FullTimeTeacher fullTimeTeacher) {
        FullTimeTeacher updatedFullTimeTeacher = fullTimeTeacherService.updateFullTimeTeacher(fullTimeTeacher);
        return new ResponseEntity<>(updatedFullTimeTeacher, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFullTimeTeacherById(@PathVariable Long id) {
        fullTimeTeacherService.deleteFullTimeTeacherById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<FullTimeTeacher> findFullTimeTeacherById(@PathVariable Long id) {
        FullTimeTeacher foundFullTimeTeacher = fullTimeTeacherService.findFullTimeTeacherById(id);
        return new ResponseEntity<>(foundFullTimeTeacher, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<FullTimeTeacher>> findAllFullTimeTeachers() {
        List<FullTimeTeacher> listFullTimeTeacher = fullTimeTeacherService.findAllFullTimeTeachers();
        return new ResponseEntity<>(listFullTimeTeacher, HttpStatus.OK);
    }
}

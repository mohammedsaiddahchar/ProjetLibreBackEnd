package net.atos.controller;

import net.atos.model.PartTimeTeacher;
import net.atos.service.PartTimeTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/parttimeteacher")
public class PartTimeTeacherController {
    @Autowired
    PartTimeTeacherService partTimeTeacherService;

    @RequestMapping("")
    public String index() {
        return "hoho";
    }

    @PostMapping("/add")
    public ResponseEntity<PartTimeTeacher> addPartTimeTeacher(@RequestBody PartTimeTeacher partTimeTeacher) {
        PartTimeTeacher newPartTimeTeacher = partTimeTeacherService.addPartTimeTeacher(partTimeTeacher);
        return new ResponseEntity<>(newPartTimeTeacher, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<PartTimeTeacher> updatePartTimeTeacher(@RequestBody PartTimeTeacher partTimeTeacher) {
        PartTimeTeacher updatedPartTimeTeacher = partTimeTeacherService.updatePartTimeTeacher(partTimeTeacher);
        return new ResponseEntity<>(updatedPartTimeTeacher, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePartTimeTeacherById(@PathVariable Long id) {
        partTimeTeacherService.deletePartTimeTeacherById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<PartTimeTeacher> findPartTimeTeacherById(@PathVariable Long id) {
        PartTimeTeacher foundPartTimeTeacher = partTimeTeacherService.findPartTimeTeacherById(id);
        return new ResponseEntity<>(foundPartTimeTeacher, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PartTimeTeacher>> findAllPartTimeTeachers() {
        List<PartTimeTeacher> listPartTimeTeacher = partTimeTeacherService.findAllPartTimeTeachers();
        return new ResponseEntity<>(listPartTimeTeacher, HttpStatus.OK);
    }
}

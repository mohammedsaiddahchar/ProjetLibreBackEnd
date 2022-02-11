package net.atos.controller;

import net.atos.model.Subject;
import net.atos.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/subject")
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @RequestMapping("")
    public String index() {
        return "hoho";
    }

    @PostMapping("/add")
    public ResponseEntity<Subject> addSubject(@RequestBody Subject subject) {
        Subject newSubject = subjectService.addSubject(subject);
        return new ResponseEntity<>(newSubject, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Subject> updateSubject(@RequestBody Subject subject) {
        Subject updatedSubject = subjectService.updateSubject(subject);
        return new ResponseEntity<>(updatedSubject, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFullTimeTeacherById(@PathVariable Long id) {
        subjectService.deleteSubjectById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Subject> findSubjectById(@PathVariable Long id) {
        Subject foundSubject = subjectService.findSubjectById(id);
        return new ResponseEntity<>(foundSubject, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Subject>> findAllSubjects() {
        List<Subject> listSubject = subjectService.findAllSubjects();
        return new ResponseEntity<>(listSubject, HttpStatus.OK);
    }
}

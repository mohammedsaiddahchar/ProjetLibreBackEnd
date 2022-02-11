package net.atos.service;

import net.atos.exception.TeacherNotFoundException;
import net.atos.model.Teacher;
import net.atos.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepo;

    public Teacher addTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    public Teacher updateTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    public Teacher findTeacherById(Long id) {
        return teacherRepo.findTeacherById(id).orElseThrow(() -> new TeacherNotFoundException("Teacher by id : " + id + " was not found."));
    }

    public List<Teacher> findAllTeachers() {
        return teacherRepo.findAll();
    }

    public void deleteTeacherById(Long id) {
        teacherRepo.deleteTeacherById(id);
    }
}

package net.atos.service;

import net.atos.exception.FullTimeTeacherNotFoundException;
import net.atos.exception.PartTimeTeacherNotFoundException;
import net.atos.model.FullTimeTeacher;
import net.atos.model.PartTimeTeacher;
import net.atos.repository.PartTimeTeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartTimeTeacherService {
    @Autowired
    PartTimeTeacherRepository partTimeTeacherRepo;

    public PartTimeTeacher addPartTimeTeacher(PartTimeTeacher partTimeTeacher) {
        return partTimeTeacherRepo.save(partTimeTeacher);
    }

    public PartTimeTeacher updatePartTimeTeacher(PartTimeTeacher partTimeTeacher) {
        return partTimeTeacherRepo.save(partTimeTeacher);
    }

    public PartTimeTeacher findPartTimeTeacherById(Long id) {
        return partTimeTeacherRepo.findPartTimeTeacherById(id).orElseThrow(() -> new PartTimeTeacherNotFoundException("Part-time Teacher by id : " + id + " was not found."));
    }

    public List<PartTimeTeacher> findAllPartTimeTeachers() {
        return partTimeTeacherRepo.findAll();
    }

    public void deleteById(Long id) {
        partTimeTeacherRepo.deletePartTimeTeacherById(id);
    }
}

package net.atos.service;

import net.atos.exception.FullTimeTeacherNotFoundException;
import net.atos.exception.UserNotFoundException;
import net.atos.model.FullTimeTeacher;
import net.atos.model.User;
import net.atos.repository.FullTimeTeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FullTimeTeacherService {
    @Autowired
    FullTimeTeacherRepository fullTimeTeacherRepo;

    public FullTimeTeacher addFullTimeTeacher(FullTimeTeacher fullTimeTeacher) {
        return fullTimeTeacherRepo.save(fullTimeTeacher);
    }

    public FullTimeTeacher updateFullTimeTeacher(FullTimeTeacher fullTimeTeacher) {
        return fullTimeTeacherRepo.save(fullTimeTeacher);
    }

    public FullTimeTeacher findFullTimeTeacherById(Long id) {
        return fullTimeTeacherRepo.findFullTimeTeacherById(id).orElseThrow(() -> new FullTimeTeacherNotFoundException("Full-time Teacher by id : " + id + " was not found."));
    }

    public List<FullTimeTeacher> findAllFullTimeTeachers() {
        return fullTimeTeacherRepo.findAll();
    }

    public void deleteFullTimeTeacherById(Long id) {
        fullTimeTeacherRepo.deleteFullTimeTeacherById(id);
    }

}

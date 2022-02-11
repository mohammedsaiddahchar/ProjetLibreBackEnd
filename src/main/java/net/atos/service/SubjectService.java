package net.atos.service;

import net.atos.exception.SubjectNotFoundException;
import net.atos.model.Subject;
import net.atos.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepo;

    public Subject addSubject(Subject subject) {
        return subjectRepo.save(subject);
    }

    public Subject updateSubject(Subject subject) {
        return subjectRepo.save(subject);
    }

    public Subject findSubjectById(Long id) {
        return subjectRepo.findSubjectById(id).orElseThrow(() -> new SubjectNotFoundException("Subject by id : " + id + " was not found."));
    }

    public List<Subject> findAllSubjects() {
        return subjectRepo.findAll();
    }

    public void deleteSubjectById(Long id) {
        subjectRepo.deleteSubjectById(id);
    }
}

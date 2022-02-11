package net.atos.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToMany()
    List<Subject> listSubject;

    @ManyToOne()
    FullTimeTeacher moduleManager;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Subject> getListSubject() {
        return listSubject;
    }

    public void setListSubject(List<Subject> listSubject) {
        this.listSubject = listSubject;
    }

    public FullTimeTeacher getModuleManager() {
        return moduleManager;
    }

    public void setModuleManager(FullTimeTeacher moduleManager) {
        this.moduleManager = moduleManager;
    }
}

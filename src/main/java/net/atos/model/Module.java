package net.atos.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "code", nullable = false, unique = true)
    String code;

    @Column(name = "designation", nullable = false)
    String designation;

    @Column(name = "level", nullable = false)
    Integer level;

    @ManyToMany(cascade = CascadeType.ALL)
    List<Subject> listSubject;

    @ManyToOne(cascade = CascadeType.ALL)
    FullTimeTeacher moduleManager;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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

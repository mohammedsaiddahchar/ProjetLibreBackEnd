package net.atos.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "code", nullable = false, unique = true)
    String code;

    @Column(name = "designation", nullable = false)
    String designation;

    @Column(name = "module")
    @ManyToMany()
    List<Module> listModule;

    @OneToOne()
    FullTimeTeacher sectorManager;

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

    public List<Module> getListModule() {
        return listModule;
    }

    public void setListModule(List<Module> listModule) {
        this.listModule = listModule;
    }

    public FullTimeTeacher getSectorManager() {
        return sectorManager;
    }

    public void setSectorManager(FullTimeTeacher sectorManager) {
        this.sectorManager = sectorManager;
    }
}

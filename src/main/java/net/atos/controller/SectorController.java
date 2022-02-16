package net.atos.controller;

import net.atos.model.FullTimeTeacher;
import net.atos.model.Module;
import net.atos.model.Sector;
import net.atos.model.Subject;
import net.atos.service.SectorService;
import net.atos.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/sector")
public class SectorController {
    @Autowired
    SectorService sectorService;

    @RequestMapping("")
    public String index() {
        FullTimeTeacher teacher = new FullTimeTeacher();
        teacher.setFirstName("Hassan");
        teacher.setLastName("Badir");
        teacher.setMailAddress("hbadir@gmail.com");

        Subject subject = new Subject();
        subject.setDesignation("Subject 1");
        subject.setTeacher(teacher);
        List<Subject> listSubject = new ArrayList<>();
        listSubject.add(subject);

        Module module = new Module();
        module.setCode("MOD1");
        module.setDesignation("Mon premier module.");
        module.setModuleManager(teacher);
        module.setLevel(2);
        module.setListSubject(listSubject);
        List<Module> listModule = new ArrayList<>();
        listModule.add(module);
        Sector sector = new Sector();
        sector.setCode("GINF");
        sector.setDesignation("Génie Informatique");
        sector.setSectorManager(teacher);
        sector.setListModule(listModule);

        sectorService.addSector(sector);
        return "ok";
    }

    @PostMapping("/add")
    public ResponseEntity<Sector> addSector(@RequestBody Sector sector) {
        Sector newSector = sectorService.addSector(sector);
        return new ResponseEntity<>(newSector, HttpStatus.OK);
    }

    @Transactional
    @PutMapping("/update")
    public ResponseEntity<Sector> updateSector(@RequestBody Sector sector) {
        Sector updatedSector = sectorService.updateSector(sector);
        return new ResponseEntity<>(updatedSector, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSectorById(@PathVariable Long id) {
        sectorService.deleteSectorById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
    @GetMapping("/find/{id}")
    public ResponseEntity<Sector> findSectorById(@PathVariable Long id) {
        Sector foundSector = sectorService.findSectorById(id);
        return new ResponseEntity<>(foundSector, HttpStatus.OK);
    }
    */

    @GetMapping("/find/{code}")
    public ResponseEntity<Sector> findSectorByCode(@PathVariable String code) {
        Sector foundSector = sectorService.findSectorByCode(code);
        return new ResponseEntity<>(foundSector, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Sector>> findAllSectors() {
        List<Sector> listSector = sectorService.findAllSectors();
        return new ResponseEntity<>(listSector, HttpStatus.OK);
    }
}

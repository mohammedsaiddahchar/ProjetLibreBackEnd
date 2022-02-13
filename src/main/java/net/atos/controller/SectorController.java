package net.atos.controller;

import net.atos.model.Sector;
import net.atos.model.Subject;
import net.atos.service.SectorService;
import net.atos.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/sector")
public class SectorController {
    @Autowired
    SectorService sectorService;

    @RequestMapping("")
    public String index() {
        return "hoho";
    }

    @PostMapping("/add")
    public ResponseEntity<Sector> addSector(@RequestBody Sector sector) {
        Sector newSector = sectorService.addSector(sector);
        return new ResponseEntity<>(newSector, HttpStatus.OK);
    }

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

    @GetMapping("/find/{id}")
    public ResponseEntity<Sector> findSectorById(@PathVariable Long id) {
        Sector foundSector = sectorService.findSectorById(id);
        return new ResponseEntity<>(foundSector, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Sector>> findAllSectors() {
        List<Sector> listSector = sectorService.findAllSectors();
        return new ResponseEntity<>(listSector, HttpStatus.OK);
    }
}

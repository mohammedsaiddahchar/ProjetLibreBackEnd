package net.atos.controller;

import net.atos.model.Module;
import net.atos.model.Subject;
import net.atos.service.ModuleService;
import net.atos.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/module")
public class ModuleController {
    @Autowired
    ModuleService moduleService;

    @RequestMapping("")
    public String index() {
        return "hoho";
    }

    @PostMapping("/add")
    public ResponseEntity<Module> addModule(@RequestBody Module module) {
        Module newModule = moduleService.addModule(module);
        return new ResponseEntity<>(newModule, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Module> updateModule(@RequestBody Module module) {
        Module updatedModule = moduleService.updateModule(module);
        return new ResponseEntity<>(updatedModule, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteModuleById(@PathVariable Long id) {
        moduleService.deleteModuleById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Module> findModuleById(@PathVariable Long id) {
        Module foundModule = moduleService.findModuleById(id);
        return new ResponseEntity<>(foundModule, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Module>> findAllModules() {
        List<Module> listModule = moduleService.findAllModules();
        return new ResponseEntity<>(listModule, HttpStatus.OK);
    }
}

package net.atos.service;


import net.atos.exception.ModuleNotFoundException;
import net.atos.exception.SubjectNotFoundException;
import net.atos.model.Module;
import net.atos.model.Subject;
import net.atos.repository.ModuleRepository;
import net.atos.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {
    @Autowired
    ModuleRepository moduleRepo;

    public Module addModule(Module module) {
        return moduleRepo.save(module);
    }

    public Module updateModule(Module module) {
        return moduleRepo.save(module);
    }

    public Module findModuleById(Long id) {
        return moduleRepo.findModuleById(id).orElseThrow(() -> new ModuleNotFoundException("Module by id : " + id + " was not found."));
    }

    public List<Module> findAllModules() {
        return moduleRepo.findAll();
    }

    public void deleteModuleById(Long id) {
        moduleRepo.deleteModuleById(id);
    }
}

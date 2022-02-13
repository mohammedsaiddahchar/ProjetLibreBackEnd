package net.atos.service;

import net.atos.exception.SectorNotFoundException;
import net.atos.exception.SubjectNotFoundException;
import net.atos.model.Sector;
import net.atos.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectorService {
    @Autowired
    SectorRepository sectorRepo;

    public Sector addSector(Sector sector) {
        return sectorRepo.save(sector);
    }

    public Sector updateSector(Sector sector) {
        return sectorRepo.save(sector);
    }

    public Sector findSectorById(Long id) {
        return sectorRepo.findSectorById(id).orElseThrow(() -> new SectorNotFoundException("Sector by id : " + id + " was not found."));
    }

    public List<Sector> findAllSectors() {
        return sectorRepo.findAll();
    }

    public void deleteSectorById(Long id) {
        sectorRepo.deleteSectorById(id);
    }
}

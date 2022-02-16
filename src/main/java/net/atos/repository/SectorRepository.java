package net.atos.repository;

import net.atos.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {
    Optional<Sector> findSectorById(Long id);

    Optional<Sector> findSectorByCode(String code);
    void deleteSectorById(Long id);
}

package net.atos.repository;

import net.atos.model.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
    Optional<Module> findModuleById(Long id);

    void deleteModuleById(Long id);
}

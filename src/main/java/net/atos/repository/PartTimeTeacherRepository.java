package net.atos.repository;

import net.atos.model.PartTimeTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartTimeTeacherRepository extends JpaRepository<PartTimeTeacher, Long> {
    Optional<PartTimeTeacher> findPartTimeTeacherById(Long id);

    void deletePartTimeTeacherById(Long id);
}

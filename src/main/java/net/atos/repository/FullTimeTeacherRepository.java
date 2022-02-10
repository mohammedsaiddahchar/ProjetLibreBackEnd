package net.atos.repository;

import net.atos.model.FullTimeTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FullTimeTeacherRepository extends JpaRepository<FullTimeTeacher, Long> {
    Optional<FullTimeTeacher> findFullTimeTeacherById(Long id);

    void deleteFullTimeTeacherById(Long id);
}

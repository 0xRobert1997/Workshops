package pl.zajavka.infrastructure.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zajavka.infrastructure.database.entity.PetEntity;

public interface PetRepository extends JpaRepository<PetEntity, Integer> {
}

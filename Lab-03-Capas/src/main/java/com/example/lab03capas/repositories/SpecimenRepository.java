package com.example.lab03capas.repositories;

import com.example.lab03capas.domain.entities.Specimen;
import org.hibernate.validator.constraints.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecimenRepository extends JpaRepository<Specimen, UUID> {
    Specimen findSpecimenById(java.util.UUID id);
}

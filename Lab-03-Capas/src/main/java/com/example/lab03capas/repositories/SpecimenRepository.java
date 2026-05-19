package com.example.lab03capas.repositories;

import com.example.lab03capas.domain.entities.Specimen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpecimenRepository extends JpaRepository<Specimen, UUID> {
    Specimen findSpecimenById(UUID id);
}

package com.example.lab03capas.services;

import com.example.lab03capas.domain.dto.requests.CreateSpecimenRequest;
import com.example.lab03capas.domain.dto.requests.UpdateSpecimenRequest;
import com.example.lab03capas.domain.dto.response.specimen.SpecimenResponse;
import org.hibernate.validator.constraints.UUID;

import java.util.List;

public interface SpecimenService {
    SpecimenResponse createSpecimen(CreateSpecimenRequest specimen);
    List<SpecimenResponse> getAllSpecimens();
    SpecimenResponse getSpecimenById(UUID id);
    SpecimenResponse updateSpecimen(UUID id, UpdateSpecimenRequest request);
    SpecimenResponse deleteSpecimen(UUID id);
}

package com.example.lab03capas.services;

import com.example.lab03capas.domain.dto.requests.CreateSpecimenRequest;
import com.example.lab03capas.domain.dto.requests.UpdateSpecimenRequest;
import com.example.lab03capas.domain.dto.response.PageableResponse;
import com.example.lab03capas.domain.dto.response.specimen.SpecimenResponse;
import java.util.UUID;
import java.util.List;

public interface SpecimenService {
    SpecimenResponse createSpecimen(CreateSpecimenRequest specimen);
    PageableResponse<SpecimenResponse> getAllSpecimens(int page, int size, String sortBy, String sortOrder);
    SpecimenResponse getSpecimenById(UUID id);
    SpecimenResponse updateSpecimen(UUID id, UpdateSpecimenRequest request);
    SpecimenResponse deleteSpecimen(UUID id);
}

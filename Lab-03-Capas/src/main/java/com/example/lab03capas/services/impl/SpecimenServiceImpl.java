package com.example.lab03capas.services.impl;

import com.example.lab03capas.common.mappers.SpecimenMapper;
import com.example.lab03capas.domain.dto.requests.CreateSpecimenRequest;
import com.example.lab03capas.domain.dto.requests.UpdateSpecimenRequest;
import com.example.lab03capas.domain.dto.response.specimen.SpecimenResponse;
import com.example.lab03capas.domain.entities.Specimen;
import com.example.lab03capas.exceptions.ResourceNotFoundException;
import com.example.lab03capas.repositories.SpecimenRepository;
import com.example.lab03capas.services.SpecimenService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecimenServiceImpl implements SpecimenService {
    private final SpecimenRepository specimenRepository;
    private final SpecimenMapper specimenMapper;

    @Override
    @Transactional
    public SpecimenResponse createSpecimen(CreateSpecimenRequest request) {
        return specimenMapper.toDto(
                specimenRepository.save(specimenMapper.toEntityCreate(request))
        );
    }

    @Override
    public List<SpecimenResponse> getAllSpecimens() {
        List<Specimen> specimens = specimenRepository.findAll();
        if (specimens.isEmpty())
            throw new ResourceNotFoundException("No specimens are registered in Hyrule");

        return specimenMapper.toDtoList(specimenRepository.findAll());
    }

    @Override
    public SpecimenResponse getSpecimenById(UUID id) {
        return specimenMapper.toDto(specimenRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Specimen not found in Hyrule Records"))
        );
    }

    @Override
    @Transactional
    public SpecimenResponse updateSpecimen(UUID id, UpdateSpecimenRequest request) {
        this.getSpecimenById(id);
        return specimenMapper.toDto(specimenRepository.save(specimenMapper.toEntityUpdate(request, id)));
    }

    @Transactional
    public SpecimenResponse deleteSpecimen(UUID id) {
        SpecimenResponse existSpecimen = this.getSpecimenById(id);
        specimenRepository.deleteById(id);
        return existSpecimen;
    }
}
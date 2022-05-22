package com.nutriadvisor.foodservice.services;



import com.nutriadvisor.foodservice.dto.ReceipeDTO;
import com.nutriadvisor.foodservice.dto.builders.ReceipeBuilder;
import com.nutriadvisor.foodservice.errorhandler.ResourceNotFoundException;
import com.nutriadvisor.foodservice.model.Receipe;
import com.nutriadvisor.foodservice.repositories.ReceipeRepository;
import com.nutriadvisor.foodservice.validators.ReceipeFieldsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReceipeService {

    private final ReceipeRepository receipeRepository;

    @Autowired
    public ReceipeService(ReceipeRepository receipeRepository) {
        this.receipeRepository = receipeRepository;
    }

    public List<ReceipeDTO> findAll() {
        List<Receipe> receipes = receipeRepository.findAll();
        return receipes.stream().map(ReceipeBuilder::generateDTOFromEntity).collect(Collectors.toList());
    }

    public Integer insert(ReceipeDTO receipeDTO) {
        ReceipeFieldsValidator.validateInsertOrUpdate(receipeDTO);
        return receipeRepository.save(ReceipeBuilder.generateEntityFromDTO(receipeDTO)).getId();
    }

    public Integer update(ReceipeDTO receipeDTO) {
        Optional<Receipe> receipe = receipeRepository.findById(receipeDTO.getId());
        if (!receipe.isPresent()) {
            throw new ResourceNotFoundException("Receipe", "receipe id", receipeDTO.getId());
        }

        ReceipeFieldsValidator.validateInsertOrUpdate(receipeDTO);

        return receipeRepository.save(ReceipeBuilder.generateEntityFromDTO(receipeDTO)).getId();
    }

    public void delete(Integer id) {
        this.receipeRepository.deleteById(id);
    }
}

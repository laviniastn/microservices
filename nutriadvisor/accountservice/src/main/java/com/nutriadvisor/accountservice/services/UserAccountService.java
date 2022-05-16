package com.nutriadvisor.accountservice.services;


import com.nutriadvisor.accountservice.dto.UserAccountDTO;
import com.nutriadvisor.accountservice.dto.builders.UserAccountBuilder;
import com.nutriadvisor.accountservice.errorhandler.ResourceNotFoundException;
import com.nutriadvisor.accountservice.model.UserAccount;
import com.nutriadvisor.accountservice.repositories.UserAccountRepository;
import com.nutriadvisor.accountservice.validators.UserFieldsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserAccountService {

    private final UserAccountRepository userRepository;

    @Autowired
    public UserAccountService(UserAccountRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserAccountDTO> findAll() {
        List<UserAccount> persons = userRepository.findAll();
        return persons.stream().map(UserAccountBuilder::generateDTOFromEntity).collect(Collectors.toList());
    }

    public Integer insert(UserAccountDTO userDTO) {
        UserFieldsValidator.validateInsertOrUpdate(userDTO);
        return userRepository.save(UserAccountBuilder.generateEntityFromDTO(userDTO)).getId();
    }

    public Integer update(UserAccountDTO userDTO) {
        Optional<UserAccount> user = userRepository.findById(userDTO.getId());
        if (!user.isPresent()) {
            throw new ResourceNotFoundException("User", "user id", userDTO.getId());
        }

        UserFieldsValidator.validateInsertOrUpdate(userDTO);

        return userRepository.save(UserAccountBuilder.generateEntityFromDTO(userDTO)).getId();
    }

    public void delete(Integer id) {
        this.userRepository.deleteById(id);
    }
}

package com.nutriadvisor.accountservice.services;

import com.nutriadvisor.accountservice.dto.UserAccountDTO;
import com.nutriadvisor.accountservice.dto.mappers.UserAccountMapper;
import com.nutriadvisor.accountservice.model.UserAccount;
import com.nutriadvisor.accountservice.repositories.UserAccountRepository;
import com.nutriadvisor.accountservice.validators.UserFieldsValidator;
import errorhandler.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    public List<UserAccountDTO> findAll() {
        List<UserAccount> userAccounts = userAccountRepository.findAll();
        return userAccounts.stream().map(userAccount -> UserAccountMapper.INSTANCE.fromUserAccount(userAccount)).collect(Collectors.toList());
    }

    public Integer insert(UserAccountDTO userAccountDTO) {
        UserFieldsValidator.validateInsertOrUpdate(userAccountDTO);
        return userAccountRepository.save(UserAccountMapper.INSTANCE.toUserAccount(userAccountDTO)).getId();
    }

    public Integer update(UserAccountDTO userAccountDTO) {

        UserFieldsValidator.validateInsertOrUpdate(userAccountDTO);

        Optional<UserAccount> user = userAccountRepository.findById(UserAccountMapper.INSTANCE.toUserAccount(userAccountDTO).getId());
        if (!user.isPresent()) {
            throw new ResourceNotFoundException("UserAccount", "userAccount id", UserAccountMapper.INSTANCE.toUserAccount(userAccountDTO).getId());
        }

        return userAccountRepository.save(UserAccountMapper.INSTANCE.toUserAccount(userAccountDTO)).getId();
    }

    public void delete(Integer id) {
        this.userAccountRepository.deleteById(id);
    }
}

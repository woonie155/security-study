package io.sercurity.securityStudy.service.impl;

import io.sercurity.securityStudy.domain.Account;
import io.sercurity.securityStudy.repository.UserRepository;
import io.sercurity.securityStudy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void createUser(Account account) {
        userRepository.save(account);
    }
}

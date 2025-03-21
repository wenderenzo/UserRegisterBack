package com.example.UserRegister.application.service;

import com.example.UserRegister.domain.entity.User;
import com.example.UserRegister.domain.exception.InvalidZipCodeException;
import com.example.UserRegister.domain.exception.UserAlreadyExistsException;
import com.example.UserRegister.domain.repository.UserRepository;
import com.example.UserRegister.infrastructure.client.ViaCepClient;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ViaCepClient viaCepClient;

    public UserServiceImpl(UserRepository userRepository, ViaCepClient viaCepClient) {
        this.userRepository = userRepository;
        this.viaCepClient = viaCepClient;
    }

    @Override
    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserAlreadyExistsException("Já existe um usuário com o email " + user.getEmail());
        }

        try {
            viaCepClient.getAddress(user.getZipCode());
        } catch (Exception e) {
            throw new InvalidZipCodeException("CEP inválido: " + user.getZipCode());
        }

        return userRepository.save(user);
    }
}
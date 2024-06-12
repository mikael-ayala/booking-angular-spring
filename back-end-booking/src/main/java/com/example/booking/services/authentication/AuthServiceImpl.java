package com.example.booking.services.authentication;

import com.example.booking.dto.SignupRequestDTO;
import com.example.booking.dto.UserDTO;
import com.example.booking.entities.User;
import com.example.booking.enums.UserRole;
import com.example.booking.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;

    public UserDTO signupClient(SignupRequestDTO signupRequestDTO) {
        User user = new User();

        user.setName(signupRequestDTO.getName());
        user.setLastname(signupRequestDTO.getLastname());
        user.setEmail(signupRequestDTO.getEmail());
        user.setPhone(signupRequestDTO.getPhone());
        user.setPassword(signupRequestDTO.getPassword());

        user.setRole(UserRole.CLIENT);

        return userRepository.save(user).getDTO();
    }
}

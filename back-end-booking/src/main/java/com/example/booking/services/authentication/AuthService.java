package com.example.booking.services.authentication;

import com.example.booking.dto.SignupRequestDTO;
import com.example.booking.dto.UserDTO;

public interface AuthService {
    UserDTO signupClient(SignupRequestDTO signupRequestDTO);

    Boolean presentByEmail(String email);
}

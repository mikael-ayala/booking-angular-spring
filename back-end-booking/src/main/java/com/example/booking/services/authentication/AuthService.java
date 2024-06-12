package com.example.booking.services.authentication;

import com.example.booking.dto.SignupRequestDTO;
import com.example.booking.dto.UserDTO;

public interface AuthService {
    public UserDTO signupClient(SignupRequestDTO signupRequestDTO);
}

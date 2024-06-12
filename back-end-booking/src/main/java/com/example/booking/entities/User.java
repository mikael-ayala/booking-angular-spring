package com.example.booking.entities;

import com.example.booking.dto.UserDTO;
import com.example.booking.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;
    private String lastname;
    private String phone;
    private UserRole role;

    public UserDTO getDTO() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);
        userDTO.setName(name);
        userDTO.setEmail(email);
        userDTO.setRole(role);

        return userDTO;
    }
}

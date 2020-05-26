package main.service;

import main.dto.CreateUserDTO;
import main.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
	UserDTO createUser(CreateUserDTO userDTO);
}

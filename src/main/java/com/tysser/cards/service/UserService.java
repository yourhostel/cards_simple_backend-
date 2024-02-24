package com.tysser.cards.service;

import com.tysser.cards.dto.UserDto;
import com.tysser.cards.exception.IncorrectPasswordException;
import com.tysser.cards.exception.UserAlreadyExistException;
import com.tysser.cards.model.User;
import com.tysser.cards.repository.UserRepository;
import com.tysser.cards.util.JwtUtil;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public User registerNewUserAccount(UserDto userDto) {
        if (userRepository.findByUsername(userDto.getUsername()).isPresent()) {
            throw new UserAlreadyExistException("There is an account with that email address: " + userDto.getUsername());
        }

        User newUser = new User();
        newUser.setUsername(userDto.getUsername());
        newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        // TODO: Set additional properties on the newUser object as needed

        return userRepository.save(newUser);
    }

    public String login(String username, String password) {
        UserDetails userDetails = loadUserByUsername(username);

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new IncorrectPasswordException("Incorrect password for username: " + username);
        }

        return jwtUtil.generateToken(userDetails);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                // TODO: Set roles and authorities for the user if needed
                .build();
    }
}



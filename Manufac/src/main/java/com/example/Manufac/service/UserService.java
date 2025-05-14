package com.example.Manufac.service;

import com.example.Manufac.controllers.CustomUserDetails;
import com.example.Manufac.models.User;
import com.example.Manufac.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
    public class UserService implements UserDetailsService {
        private final UserRepository userRepository;

        @Autowired
        private ApplicationContext applicationContext;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        PasswordEncoder passwordEncoder = applicationContext.getBean(PasswordEncoder.class);
        String encodedPassword = passwordEncoder.encode(user.getPassword());


        User userWithEncodedPassword = new User(
                user.getId(),
                user.getUsername(),
                encodedPassword,
                user.getRole()
        );

        return new CustomUserDetails(userWithEncodedPassword);
    }
}

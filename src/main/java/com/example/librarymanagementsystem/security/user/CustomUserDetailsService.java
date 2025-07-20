package com.example.librarymanagementsystem.security.user;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.librarymanagementsystem.entity.SystemUser;
import com.example.librarymanagementsystem.repository.SystemUserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final SystemUserRepo systemUserRepo;

    public CustomUserDetailsService(SystemUserRepo systemUserRepo) {
        this.systemUserRepo = systemUserRepo;
    }

    @Override
    public SystemUser loadUserByUsername(String username) throws UsernameNotFoundException {
        return systemUserRepo.findByUsername(username).orElseThrow(
            () -> new UsernameNotFoundException("User not found")
        );
    }

}

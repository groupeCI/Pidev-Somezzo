package com.somezzo.usermanagement.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.somezzo.usermanagement.entity.Role;
import com.somezzo.usermanagement.entity.User;
import com.somezzo.usermanagement.repository.UserRepository;

@Configuration
public class DataLoader {

    private final UserRepository userRepository;

    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    CommandLineRunner initializeAdmin() {
        return args -> {
            String adminEmail = "nidhalgharbi5@gmail.com";
            if (!userRepository.existsByEmail(adminEmail)) {
                User admin = new User();
                admin.setName("Nidhal");
                admin.setEmail(adminEmail);
                admin.setPassword("nidhal982001"); 
                admin.setRole(Role.MANAGER);
                admin.setActive(true);

                userRepository.save(admin);
                System.out.println("Compte administrateur créé avec succès !");
            } else {
                System.out.println("Le compte administrateur existe déjà.");
            }
        };
    }
}

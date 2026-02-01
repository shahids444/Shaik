package com.medicart.auth.config;

import com.medicart.auth.entity.Role;
import com.medicart.auth.repository.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Initialize required roles on application startup.
 * This ensures that ROLE_USER exists in the database so registration can succeed.
 */
@Component
public class DataInitializer implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        // Create ROLE_USER if it doesn't exist
        if (roleRepository.findByName("ROLE_USER").isEmpty()) {
            Role userRole = Role.builder()
                    .name("ROLE_USER")
                    .description("Standard user role")
                    .build();
            roleRepository.save(userRole);
            log.info("Created ROLE_USER role");
        } else {
            log.info("ROLE_USER role already exists");
        }

        // Create ROLE_ADMIN if it doesn't exist
        if (roleRepository.findByName("ROLE_ADMIN").isEmpty()) {
            Role adminRole = Role.builder()
                    .name("ROLE_ADMIN")
                    .description("Administrator role")
                    .build();
            roleRepository.save(adminRole);
            log.info("Created ROLE_ADMIN role");
        } else {
            log.info("ROLE_ADMIN role already exists");
        }
    }
}

package com.educacionit.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.educacionit.model.Role;
import com.educacionit.repository.RoleRepository;

@Component
public class DataInit implements CommandLineRunner{
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.count() == 0) {
            Role admin = new Role();
            admin.setName("ADMIN");
            roleRepository.save(admin);

            Role users = new Role();
            users.setName("USER");
            roleRepository.save(users);
        }
    }

}

package io.github.matheusfsantos.model.config;

import io.github.matheusfsantos.model.domain.Users;
import io.github.matheusfsantos.model.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.*;

@Configuration
public class DatabaseConfiguration {

    @Bean
    public CommandLineRunner init(
            @Autowired UsersRepository usersRepository
    ) {
        return args -> {
            Users user1 = new Users(UUID.randomUUID().toString(), "Usuário Teste 1", "05875350", "120-A", "Apartamento Bloco A", 10.0, 10.0, LocalDateTime.now(), LocalDateTime.now());
            Users user2 = new Users(UUID.randomUUID().toString(), "Usuário Teste 2", "05875350", "120-B", "Apartamento Bloco B", 10.0, 10.0, LocalDateTime.now(), LocalDateTime.now());
            Users user3 = new Users(UUID.randomUUID().toString(), "Usuário Teste 3", "05875350", "120-C", "Apartamento Bloco C", 10.0, 10.0, LocalDateTime.now(), LocalDateTime.now());
            Users user4 = new Users(UUID.randomUUID().toString(), "Usuário Teste 4", "05875350", "120-D", "Apartamento Bloco D", 10.0, 10.0, LocalDateTime.now(), LocalDateTime.now());

            List<Users> usersList = new ArrayList<Users>(Arrays.asList(user1, user2, user3, user4));
            usersList.forEach(usersRepository::save);
        };
    }

}

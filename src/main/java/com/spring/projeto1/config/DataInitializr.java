package com.spring.projeto1.config;

import com.spring.projeto1.entity.User;
import com.spring.projeto1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UserRepository userRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        System.out.println("Acessando o projeto");

        List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            User user = new User();
            user.setEmail("elaynegomes@gmail.com");
            user.setNome("Elayne");

            userRepository.save(user);
        }

    }

}
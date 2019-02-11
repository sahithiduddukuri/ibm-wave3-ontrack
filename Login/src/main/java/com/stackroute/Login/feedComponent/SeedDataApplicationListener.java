package com.stackroute.Login.feedComponent;

import com.stackroute.Login.model.User;
import com.stackroute.Login.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@Data
@Primary
public class SeedDataApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private UserRepository userRepository;

    @Autowired
    public SeedDataApplicationListener(UserRepository userRepository){this.userRepository = userRepository;}
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        userRepository.save(new User("kalpesh","gharte"));
        userRepository.save(new User("pratik","gharte"));
    }
}

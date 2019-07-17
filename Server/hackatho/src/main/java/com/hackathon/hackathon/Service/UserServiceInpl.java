package com.hackathon.hackathon.Service;

import com.hackathon.hackathon.Domain.User;
import com.hackathon.hackathon.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserServiceInpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        User member = new User("member", "1234", "나", "12345678", "parent");
        User parent = new User("parent", "1234", "엄마", "12345678", null);
        userRepository.save(member);
        userRepository.save(parent);
    }

    @Override
    public User login(User user) {
        return userRepository.findByUsername(user.getUsername())
                .map( v -> {
                    if(v.getPassword().equals(user.getPassword())) {
                        return v;
                    } else {
                        return null;
                    }
                })
                .orElse(null);
    }

}

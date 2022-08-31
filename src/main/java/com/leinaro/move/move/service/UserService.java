package com.leinaro.move.move.service;

import com.leinaro.move.move.entity.User;
import com.leinaro.move.move.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User createUser(User user){
        User newUser = userRepository.save(user);
        return newUser;
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getUserByAuthUid(String authUid){
        Optional<User> user = userRepository.findByAuthUid(authUid);
        if(user.isPresent()){
            return user.get();
        }else{
            //TODO exception when empty
            return new User();
        }
    }


    public User validateUser(Map<String, String> data) {

        Optional<User> user = userRepository.findByAuthUid(data.get("uid"));
        if(user.isEmpty()){
            //create User
            User newUser = new User(data.get("uid"),data.get("name"),data.get("email"));
            return userRepository.save(newUser);
        }else{
            return user.get();
        }

    }
}

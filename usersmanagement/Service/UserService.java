package com.example.usersmanagement.Service;

import com.example.usersmanagement.ApiException.ApiException;
import com.example.usersmanagement.Model.User;
import com.example.usersmanagement.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public List<User> getusers(){
        return userRepository.findAll();
    }
    public void addUsers(User user){
        userRepository.save(user);
    }
    public void updateUsers(Integer id, User user){
        User olduser=userRepository.findUserById(id);
        if(olduser==null){
            throw new ApiException("id not found");
        }
        olduser.setName(user.getName());
        olduser.setUsername(user.getUsername());
        olduser.setPassword(user.getPassword());
        olduser.setEmail(user.getEmail());
        olduser.setRole(user.getRole());
        olduser.setAge(user.getAge());
        userRepository.save(olduser);
    }
    public void deleteUser(Integer id){
        User oldUser=userRepository.findUserById(id);
        if(oldUser==null){
            throw new ApiException("id not found");
        }
        userRepository.delete(oldUser);
    }
public User getEmail(String email){
        User user=userRepository.findUserByEmail(email);
        if(user==null){
            throw new ApiException("email not found");
        }
        return user;
}
public List<User> getRole(String role){
        List<User> users=userRepository.findUsersByRole(role);
        if(users==null){
            throw new ApiException("user not found");
        }
        return users;

}
    public List<User> getAgr(Integer age){
        List<User> users=userRepository.findUserByAge(age);
        if(users==null){
            throw new ApiException("User not found");
        }
        return users;

    }
    public User check(String username,String password){
        User user=userRepository.findUserByUsernameAndPassword(username, password);
        if(user==null){
            throw new ApiException("user not found");
        }
        return user;
    }
}

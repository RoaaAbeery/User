package com.example.usersmanagement.Repository;

import com.example.usersmanagement.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserById(Integer id);
    @Query("select u from User u where u.email=?1")
    User findUserByEmail(String email);

    @Query("select u from User u where u.role=?1")
    List<User> findUsersByRole(String role);
    @Query("select u from User u where u.age>=?1")
    List<User> findUserByAge(Integer age);

    @Query("select u from User u where u.username=?1 and u.password=?2")
     User findUserByUsernameAndPassword(String username,String password);



}

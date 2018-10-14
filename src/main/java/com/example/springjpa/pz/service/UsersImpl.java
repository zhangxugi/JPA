package com.example.springjpa.pz.service;


import com.example.springjpa.pz.pojo.Users;
import com.example.springjpa.pz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsersImpl implements Userservice{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Users> getUserList() {

        return userRepository.findAll();
    }

    @Override
    public Users findUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(Users user) {
        userRepository.save(user);
    }

    @Override
    public void edit(Users user) {
        userRepository.save(user);
    }
    @Transactional
    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Page<Users> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}

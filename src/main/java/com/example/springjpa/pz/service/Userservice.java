package com.example.springjpa.pz.service;

import com.example.springjpa.pz.pojo.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface Userservice {
    public List<Users>getUserList();
    public Users findUserById(long id);
    public void save(Users user);
    public void edit(Users user);
    public void delete(long id);
    //分页
    public Page<Users> findAll(Pageable pageable);
}

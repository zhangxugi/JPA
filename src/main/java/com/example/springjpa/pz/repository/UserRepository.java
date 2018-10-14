package com.example.springjpa.pz.repository;

import com.example.springjpa.pz.pojo.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<Users,Long> {
    Users findById(long id);
    void deleteById(Long id);
    //分页
    Page<Users> findAll(Pageable Pageable);
}

package cn.com.kiva.springdemo.dao;

import cn.com.kiva.springdemo.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UsersRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    @Override
    <S extends User> S save(S s);

    @Override
    <S extends User> S saveAndFlush(S s);
}
package cn.com.kiva.springdemo.dao;

import cn.com.kiva.springdemo.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersDoc extends MongoRepository<User,Long> {

    @Override
    List<User> findAll();


    @Override
    <S extends User> S insert(S s);
}

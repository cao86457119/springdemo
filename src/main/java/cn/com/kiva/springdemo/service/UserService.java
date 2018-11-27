package cn.com.kiva.springdemo.service;


import cn.com.kiva.springdemo.dao.UsersDoc;
import cn.com.kiva.springdemo.dao.UsersRepository;
import cn.com.kiva.springdemo.mapper.JavaDemo1.UserDao;
import cn.com.kiva.springdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //声明成一个spring bean
public class UserService {

    @Autowired //连接到UserDao Bean
    private UserDao userDao;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersDoc usersDocRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public String show() {
        return "Hello World! UserDao";
    }

    public List<User> showDao(String age) {
        return userDao.get(age);
    }
    @Cacheable(key="'user_'+#id", value="demo1")
    public User showDao1(int id) {
        System.err.println("缓存里没有"+id+",所以这边没有走缓存，从数据库拿数据");
        return userDao.getUserById(id);
    }

    @Cacheable(key="'user_'+#id", value="demo1")
    public User checkUser(int id) {
        System.err.println("缓存里没有"+id+",所以这边没有走缓存，从数据库拿数据");
        return userDao.getUserById(id);
    }

//    public String insert(String name, String age) { //插入一条记录
//        User user = new User();
//        user.setUsername(name);
//        user.setAge(age);
//        userDao.insert(user);
//        return "Insert ( \""+name+"\", age"+age+") OK!";
//    }

    public void insert(User user){
        usersRepository.saveAndFlush(user);

    }
}
package cn.com.kiva.springdemo.mapper.JavaDemo1;

import cn.com.kiva.springdemo.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper //1
@Component
public interface UserDao {
    @Results({ //2
            @Result(property = "id", column = "id"), //2
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })

    @Select("SELECT * FROM user WHERE id = #{id}") //3
    User getUserById(int id);

    @Select("SELECT * FROM user WHERE Username = #{username}") //3
    User getUserByName(String username);

    @Select("SELECT * FROM user WHERE age = #{age}") //3
    List<User> get(String age);

    @Insert("INSERT INTO user(name, age) VALUES (#{name}, #{age})") //3
    void insert(User user);
}

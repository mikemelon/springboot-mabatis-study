package cn.lynu.lyq.springbootmybatisstudy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.lynu.lyq.springbootmybatisstudy.entities.User;

@Mapper
public interface UserDao {
	@Select("SELECT * from user")
	List<User> getAllUsers();
	
	@Select("SELECT ID as id, NAME as name, SEX as sex, AGE as age	FROM user WHERE ID=#{id}")
	User getUserById(@Param("id") int id);
	
	@Update("UPDATE user SET NAME=#{user.name} SEX=#{user.sex}, AGE=#{user.age} WHERE ID = #{user.id}")
	int updateUser(@Param("user")User user);
	
	@Insert("INSERT INTO user(id, name, sex, age) VALUES ( #{user.id}, #{user.name}, #{user.sex}, #{user.age} )")
	int insertUser(@Param("user")User user);
	
	@Delete("DELETE user WHERE ID = #{id}")
	int deleteUserById(@Param("id")int id);
	
}

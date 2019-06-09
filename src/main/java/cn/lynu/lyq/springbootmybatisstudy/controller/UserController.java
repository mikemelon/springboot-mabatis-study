package cn.lynu.lyq.springbootmybatisstudy.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.lynu.lyq.springbootmybatisstudy.dao.UserDao;
import cn.lynu.lyq.springbootmybatisstudy.entities.User;

@RestController
public class UserController {
	
	@Resource
	private UserDao userDao;
	
	@RequestMapping("/users")
    public List<User> getAll(){
        return userDao.getAllUsers();
    }
	
	@RequestMapping("/user/{id}")
	public User getSpecificUser(@PathVariable("id") int id){
		return userDao.getUserById(id);
	}
	

}

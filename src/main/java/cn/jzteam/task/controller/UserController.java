package cn.jzteam.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jzteam.task.dao.entity.UserEntity;
import cn.jzteam.task.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private IUserService userService;
    
    @RequestMapping("/get")
    public UserEntity get(Integer id,Model model){
        UserEntity userEntity = userService.get(id);
        model.addAttribute("user",userEntity);
        
        return userEntity;
    }

}

package cn.skr.ilovectrl.controller;

import cn.skr.ilovectrl.pojo.User;
import cn.skr.ilovectrl.repository.FoodRepository;
import cn.skr.ilovectrl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user/login")
    public String login(User user){

        List<User> list = userRepository.findByNameAndPassword(user.getName(),user.getPassword());

        System.out.println(list);

        if(!list.isEmpty()){

            return "redirect:/foods.html";
        }
        else return "redirect:/index.html";

    }


}

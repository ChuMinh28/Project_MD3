package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import project.model.entity.User;
import project.model.service.UserService;

import java.util.List;

@Controller
@RequestMapping("userController")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("GetAll")
    public ModelAndView getAllUSer(){
        ModelAndView modelAndView = new ModelAndView("/admin/listUser");
        List<User> userList = userService.findAll();
        modelAndView.addObject("listUser",userList);
        return modelAndView;
    }
    @PostMapping("create")
    public String createUser(User user, @RequestParam String confirm,@RequestParam String userPassWord){
        if (userPassWord.equals(confirm)){
            boolean result = userService.save(user);
            if (result) {
                return "/user/login";
            }else {
                return "/user/error";
            }
        } else {
            return "/user/error";
        }
    }
    @GetMapping("delete")
    public String deleteUser(int userID){
        boolean result = userService.lockUser(userID);
        if (result) {
            return "redirect:GetAll";
        } else {
            return "/user/error";
        }
    }
    @GetMapping("unlock")
    public String unlock(int userID){
        boolean result = userService.unLockUser(userID);
        if (result) {
            return "redirect:GetAll";
        }else {
            return "/user/error";
        }
    }
}

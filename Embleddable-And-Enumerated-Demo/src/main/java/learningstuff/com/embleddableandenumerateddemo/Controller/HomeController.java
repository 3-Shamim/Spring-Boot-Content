package learningstuff.com.embleddableandenumerateddemo.Controller;

import learningstuff.com.embleddableandenumerateddemo.Model.Gender;
import learningstuff.com.embleddableandenumerateddemo.Model.User;
import learningstuff.com.embleddableandenumerateddemo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "userAPI")
    @ResponseBody
    public User userAPI()
    {

        return  userRepository.getOne(1);
    }
    @GetMapping(value = "allUsersAPI")
    @ResponseBody
    public List<User> usersAPI()
    {

        return  userRepository.findAll();
    }

    @GetMapping(value = "allUsers")
    public ModelAndView users()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "Users");
        modelAndView.addObject("userList", userRepository.findAll());
        modelAndView.setViewName("users");

        return  modelAndView;
    }



    @GetMapping(value = "addUser")
    public ModelAndView addUser()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "user");
        modelAndView.addObject("genders", Gender.values());
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("addUser");

        return  modelAndView;
    }

    @PostMapping(value = "addUser")
    public ModelAndView processAddUser(@ModelAttribute @Valid User user, BindingResult bindingResult, @RequestParam(value = "gender") String gender)
    {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors())
        {
            modelAndView.setViewName("addUser");
            modelAndView.addObject("genders", Gender.values());
            return  modelAndView;
        }

        user.setGender(Gender.valueOf(gender));

        userRepository.save(user);

        modelAndView.setViewName("redirect:/allUsers");

        return  modelAndView;
    }

}

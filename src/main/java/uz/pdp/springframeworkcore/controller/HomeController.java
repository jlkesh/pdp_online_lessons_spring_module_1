package uz.pdp.springframeworkcore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("username", "nurislom");
        return modelAndView;
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin() {
        return "Admin Page";
    }

    @GetMapping("/user")
    @ResponseBody
    public String user() {
        return "User Page";
    }


}

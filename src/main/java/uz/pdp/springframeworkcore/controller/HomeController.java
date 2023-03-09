package uz.pdp.springframeworkcore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.springframeworkcore.vo.Blog;

@Controller
public class HomeController {

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("username", "nurislom");
        return modelAndView;
    }

}

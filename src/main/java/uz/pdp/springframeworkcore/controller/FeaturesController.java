package uz.pdp.springframeworkcore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.springframeworkcore.vo.Blog;

import java.util.List;
import java.util.UUID;

@Controller
public class FeaturesController {

    @GetMapping("/text")
    public ModelAndView text() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("text");
        modelAndView.addObject("username", "Javohir");
        return modelAndView;
    }

    @GetMapping("/se")
    public ModelAndView se() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("se");
        modelAndView.addObject("blog", new Blog("1", "Spring New Features", "Spring 6. has a lot .............."));
        return modelAndView;
    }

    @GetMapping("/literals")
    public ModelAndView literals() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("literals");
        modelAndView.addObject("user", "Javohir Elmurodov");
        return modelAndView;
    }

    @GetMapping("/arithmetic_operators")
    public ModelAndView arithmetic_operators() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("arithmetic_operators");
        return modelAndView;
    }

    @GetMapping("/comparators_operators")
    public ModelAndView comparators_operators() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("comparators_operators");
        return modelAndView;
    }

    @GetMapping("/nooperationtoken")
    public ModelAndView nooperationtoken() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("nooperationtoken");
        modelAndView.addObject("user", "Javohir Elmurodov");
        return modelAndView;
    }

    @GetMapping("/setattr")
    public ModelAndView setattr() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("setattr");
        modelAndView.addObject("blog", new Blog("1", "Spring New Features", "Spring 6. has a lot .............."));
        return modelAndView;
    }

    @GetMapping("/append")
    public ModelAndView append() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("append");
        modelAndView.addObject("operations", List.of("danger", "success", "primary", "warning"));
        modelAndView.addObject("user_status", true);
        modelAndView.addObject("user_language", "en");
        return modelAndView;
    }

    @GetMapping("/each")
    public ModelAndView each() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("each");
        modelAndView.addObject("operations", List.of("danger", "success", "primary", "warning"));
        modelAndView.addObject("blogs", List.of(
                new Blog(UUID.randomUUID().toString(), "Spring New Features", "Spring 6. has a lot .............."),
                new Blog(UUID.randomUUID().toString(), "What Is 12 factor", "Cloud Applications")
        ));
        return modelAndView;
    }
    @GetMapping("/conditional")
    public ModelAndView conditional() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("conditional");
        return modelAndView;
    }

}

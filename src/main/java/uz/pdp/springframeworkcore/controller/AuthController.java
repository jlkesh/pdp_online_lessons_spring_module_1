package uz.pdp.springframeworkcore.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.springframeworkcore.daos.AuthUserDao;
import uz.pdp.springframeworkcore.domains.AuthUser;
import uz.pdp.springframeworkcore.dto.UserRegisterDTO;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final AuthUserDao authUserDao;
    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthUserDao authUserDao, PasswordEncoder passwordEncoder) {
        this.authUserDao = authUserDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public ModelAndView loginPage(@RequestParam(required = false) String error) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("auth/login");
        modelAndView.addObject("errorMessage", error);
        return modelAndView;
    }

    @GetMapping("/logout")
    public String logoutPage(Model model) {
        return "auth/logout";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "auth/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserRegisterDTO dto) {
        AuthUser authUser = AuthUser.builder()
                .username(dto.username())
                .password(passwordEncoder.encode(dto.password()))
                .build();
        Long id = authUserDao.save(authUser);
        System.out.println(id);
        return "redirect:/auth/login";
    }
}

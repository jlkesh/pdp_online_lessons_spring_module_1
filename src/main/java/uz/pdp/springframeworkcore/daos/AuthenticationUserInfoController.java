package uz.pdp.springframeworkcore.daos;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import uz.pdp.springframeworkcore.config.security.CustomUserDetails;
import uz.pdp.springframeworkcore.config.security.SessionUser;
import uz.pdp.springframeworkcore.domains.AuthUser;

@Controller
@ResponseBody
public class AuthenticationUserInfoController {


    private final SessionUser sessionUser;

    public AuthenticationUserInfoController(SessionUser sessionUser) {
        this.sessionUser = sessionUser;
    }

    @GetMapping("/create/blog")
    public String createBlog(@AuthenticationPrincipal CustomUserDetails userDetails) {
        AuthUser authUser = userDetails.getAuthUser();
        System.out.println(userDetails.getAuthorities());
        System.out.println(sessionUser.getId());
        return "Authenticated User info";
    }
}

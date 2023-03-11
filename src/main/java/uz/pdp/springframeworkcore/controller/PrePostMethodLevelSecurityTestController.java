package uz.pdp.springframeworkcore.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;

@Controller
@ResponseBody
public class PrePostMethodLevelSecurityTestController {

    @GetMapping("/has_role_admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin() {
        return "has_role_admin";
    }

    @GetMapping("/has_role_manager")
    @PreAuthorize("hasRole('MANAGER')")
    /*@Secured("MANAGER")*/
    /*@RolesAllowed({"MANAGER", "ADMIN", "USER"})*/
    public String manager() {
        return "has_role_manager";
    }

    @GetMapping("/has_any_role_admin_manager_user")
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER','USER')")
    public String profile() {
        return "admin, manager, users can see this page";
    }

    @GetMapping("/delete_manager_page")
    @PreAuthorize("hasAuthority(T(uz.pdp.springframeworkcore.config.security.Permissions).HAS_PERMISSION_DELETE_MANAGER)")
    public String deleteManagerPage() {
        return "deleteManager Page";
    }

    @GetMapping("/block_user_delete_manager")
    @PreAuthorize("hasAnyAuthority('DELETE_MANAGER','BLOCK_USER')")
    public String manageManagerPage() {
        return "block_user_delete_manager Page";
    }


}

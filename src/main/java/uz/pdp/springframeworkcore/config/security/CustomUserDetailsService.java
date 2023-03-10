package uz.pdp.springframeworkcore.config.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.springframeworkcore.daos.AuthUserDao;
import uz.pdp.springframeworkcore.domains.AuthUser;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AuthUserDao authUserDao;

    public CustomUserDetailsService(AuthUserDao authUserDao) {
        this.authUserDao = authUserDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser authUser = authUserDao.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found by username '%s'".formatted(username)));
        System.out.println(authUser);
        return new User(authUser.getUsername(), authUser.getPassword(), List.of());
    }
}

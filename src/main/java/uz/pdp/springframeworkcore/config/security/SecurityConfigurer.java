package uz.pdp.springframeworkcore.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(

        securedEnabled = true,
        jsr250Enabled = true
)
public class SecurityConfigurer {
    public static final String[] WHITE_LIST = {
            "/css/**",
            "/home",
            "/auth/login",
            "/auth/register"
    };
    private final CustomUserDetailsService userDetailsService;
    private final CustomAuthenticationFailureHandler authenticationFailureHandler;

    public SecurityConfigurer(CustomUserDetailsService userDetailsService,
                              CustomAuthenticationFailureHandler authenticationFailureHandler) {
        this.userDetailsService = userDetailsService;
        this.authenticationFailureHandler = authenticationFailureHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers(WHITE_LIST).permitAll()
                /*.requestMatchers("/admin").hasRole("ADMIN")
                .requestMatchers("/user").hasAnyRole("USER", "ADMIN")*/
                .anyRequest()
                .fullyAuthenticated();//fullyAuthenticated();

        http.formLogin()
                .loginPage("/auth/login")
                .usernameParameter("uname")
                .passwordParameter("pswd")
                .defaultSuccessUrl("/home", false)
                .failureHandler(authenticationFailureHandler);

        http.logout()
                .logoutUrl("/auth/logout")
                .deleteCookies("JSESSIONID")
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout", "POST"));

        http.rememberMe()
                .rememberMeParameter("rememberMe")
                .rememberMeCookieName("rem-me")
                .tokenValiditySeconds(24 * 60 * 60)
                .key("secret_key")
                .userDetailsService(userDetailsService);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // return NoOpPasswordEncoder.getInstance(); // do not use
        return new BCryptPasswordEncoder();
    }


     /*@Bean
     public UserDetailsService userDetailsService() {
         UserDetails user = User.withDefaultPasswordEncoder() // do not use in production
                 .username("john")
                 .password("123")
                 .roles("USER")
                 .build();
         UserDetails admin = User.withDefaultPasswordEncoder()
                 .username("jl")
                 .password("123")
                 .roles("ADMIN")

                 .build();
         return new InMemoryUserDetailsManager(user, admin);
     }*/
}
